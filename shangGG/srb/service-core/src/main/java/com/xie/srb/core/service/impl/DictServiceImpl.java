package com.xie.srb.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xie.common.exception.BusinessException;
import com.xie.srb.core.listener.ExcelDictDTOListener;
import com.xie.srb.core.mapper.DictMapper;
import com.xie.srb.core.pojo.dto.ExcelDictDTO;
import com.xie.srb.core.pojo.entity.Dict;
import com.xie.srb.core.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
@Slf4j
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Resource
    RedisTemplate redisTemplate;

    /* @Resource
     private DictMapper dictMapper;
     由于注入的mapper就是当前service的mapper就不用写 直接用baseMapper既可
     */
    //实现导入数据的方法，前端以流方式传文件进来 可添加事务
    @Override
    @Transactional(rollbackFor = {Exception.class, BusinessException.class})
    public void importData(InputStream inputStream) {
        //读取excel
        EasyExcel.read(inputStream, ExcelDictDTO.class, new ExcelDictDTOListener(baseMapper)).sheet().doRead();
        log.info("Excel导入成功");
    }

    @Override
    public List<ExcelDictDTO> listDictData() {
        //查询到数据库的数据 是不能直接写入excel的 跟我们需要的内容有区别 要转换封装为需要的excel对象
        List<Dict> dicts = baseMapper.selectList(null);
        //创建 ExcelDictDTO列表 将数据装进去 长度确定
        ArrayList<ExcelDictDTO> list = new ArrayList<>(dicts.size());
        dicts.forEach(dict -> {
            ExcelDictDTO excelDictDTO = new ExcelDictDTO();
            BeanUtils.copyProperties(dict, excelDictDTO);
            list.add(excelDictDTO);
        });
        return list;
    }
    //查看数据类别  可以在这个方法中加入业务逻辑，
    @Override
    public List<Dict> listByParentId(Long parentId) {
        //首先查询redis 是否存在数据列表 因为有parentid 而且前端页面都是 列表展示 ，一个父类存一个key
        //可以提现层次关系  这个parentId 下的列表都存起来
        try {
            List<Dict> dictList= (List<Dict>)redisTemplate.opsForValue().get("srb:core:dictList" + parentId);
            if(null!=dictList){
                log.info("从redis中获取数据");

                //如果有直接返回
                return dictList;
            }
        } catch (Exception e) {
            //拿到错误跟踪栈的字符串
            log.error("redis服务器异常:"+ ExceptionUtils.getStackTrace(e));
        }
        //如果不存在则查询数据库
        log.info("从数据库中获取数据");
        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.eq("parent_id",parentId);
        List<Dict> dictsList = baseMapper.selectList(dictQueryWrapper);
        //查询到的数据 需要再填充hasChildren字段
        dictsList.forEach(dict -> {
            //判断当前节点是否有子节点,找到当前对象的下级 有没有子节点
            dict.setHasChildren(ifHasChild(dict.getId()));
        });

        try {
            //查完数据库 将数据存入redis 设置过期时间 以达到数据同步 存1天
            log.info("将数据存入redis");
            redisTemplate.opsForValue().set("srb:core:dictList" + parentId,dictsList,1, TimeUnit.DAYS);
        } catch (Exception e) {
            log.error("redis服务器异常:"+ ExceptionUtils.getStackTrace(e));
        }
        //返回数据
        return dictsList;


    }
    /**
     * 判断当前的id所在的节点下是否有子节点
     * 如果查出来数量大于0说明有子节点
     * @param id
     * @return
     */
    private boolean ifHasChild(Long id){
        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(dictQueryWrapper);
        if(count>0){
            return true;
        }
        return false;
    }
}
