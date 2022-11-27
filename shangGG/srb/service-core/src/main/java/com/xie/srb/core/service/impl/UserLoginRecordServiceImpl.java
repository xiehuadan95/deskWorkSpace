package com.xie.srb.core.service.impl;

import com.xie.srb.core.pojo.entity.UserLoginRecord;
import com.xie.srb.core.mapper.UserLoginRecordMapper;
import com.xie.srb.core.service.UserLoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
