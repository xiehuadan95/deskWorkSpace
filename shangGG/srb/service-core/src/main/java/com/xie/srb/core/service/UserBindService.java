package com.xie.srb.core.service;

import com.xie.srb.core.pojo.entity.UserBind;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xie.srb.core.pojo.vo.UserBindVO;

/**
 * <p>
 * 用户绑定表 服务类
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
public interface UserBindService extends IService<UserBind> {

    String commitBindUser(UserBindVO userBindVO, Long userId);
}
