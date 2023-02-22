package com.xie.srb.core.service;

import com.xie.srb.core.pojo.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xie.srb.core.pojo.vo.LoginVO;
import com.xie.srb.core.pojo.vo.RegisterVO;
import com.xie.srb.core.pojo.vo.UserInfoVO;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
public interface UserInfoService extends IService<UserInfo> {

    void register(RegisterVO registerVO);

    UserInfoVO login(LoginVO loginVO, String ip);
}
