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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Dict> listByParentId(Long parentId) {
        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.eq("parent_id",parentId);
        List<Dict> dictsList = baseMapper.selectList(dictQueryWrapper);
        //查询到的数据 需要再填充hasChildren字段
        dictsList.forEach(dict -> {
            //判断当前节点是否有子节点,找到当前对象的下级 有没有子节点
            dict.setHasChildren(ifHasChild(dict.getId()));
        });
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
