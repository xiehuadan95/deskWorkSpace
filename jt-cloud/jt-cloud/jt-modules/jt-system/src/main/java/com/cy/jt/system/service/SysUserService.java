package com.cy.jt.system.service;

import com.cy.jt.system.domain.SysUser;

import java.util.List;

public interface SysUserService {
    /**
     * 基于条件查询用户信息
     * @param entity
     * @return
     */
    List<SysUser> selectUsers(SysUser entity);

    /**
     * 基于id查询用户信息,用户对应的部门信息,用户对应的角色信息
     * @param id
     * @return
     */
    SysUser selectById(Integer id);

    /**
     * 添加新的用户信息以及用户和角色关系数据
     * @param entity
     * @return
     */
    int insertUser(SysUser entity);

    /**
     * 更新用户信息以及用户和角色关系数据
     * @param entity
     * @return
     */
    int updateUser(SysUser entity);

    /**
     * 基于用户id修改用户状态(禁用,启用)
     * @param id 用户id
     * @param valid 用户状态
     * @return 更新的行数
     */
    int validById(Integer id,Integer valid);

}
