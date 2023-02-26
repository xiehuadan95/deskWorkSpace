package com.xie.srb.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xie.srb.core.pojo.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xie.srb.core.pojo.query.UserInfoQuery;
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

    //根据查询条件和分页条件 展示分页列表
    IPage<UserInfo> listPage(Page<UserInfo> pageParam, UserInfoQuery userInfoQuery);

    //根据传入的id 状态 对用户进行锁定或者解锁操作
    void lock(Long id,Integer status);


    boolean checkMobile(String mobile);
}
