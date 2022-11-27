package com.xie.srb.core.service.impl;

import com.xie.srb.core.pojo.entity.UserInfo;
import com.xie.srb.core.mapper.UserInfoMapper;
import com.xie.srb.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
