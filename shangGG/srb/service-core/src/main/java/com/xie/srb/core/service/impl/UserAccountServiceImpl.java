package com.xie.srb.core.service.impl;

import com.xie.srb.core.pojo.entity.UserAccount;
import com.xie.srb.core.mapper.UserAccountMapper;
import com.xie.srb.core.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
