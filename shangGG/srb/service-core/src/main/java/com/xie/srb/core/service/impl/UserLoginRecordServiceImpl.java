package com.xie.srb.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xie.srb.core.pojo.entity.UserLoginRecord;
import com.xie.srb.core.mapper.UserLoginRecordMapper;
import com.xie.srb.core.service.UserLoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户登录记录表 服务实现类
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements UserLoginRecordService {

    @Override
    public List<UserLoginRecord> listTop50(Long userId) {

        QueryWrapper<UserLoginRecord> queryWrapper = new QueryWrapper<>();
        //查最近的 id 倒叙 组装条件
        queryWrapper.eq("user_id",userId).orderByDesc("id").last("limit 50");

        List<UserLoginRecord> userLoginRecords = baseMapper.selectList(queryWrapper);

        return userLoginRecords;
    }
}
