package com.cy.jt.system.service;

import com.cy.jt.common.domain.CheckBox;
import com.cy.jt.system.domain.SysRole;

import java.util.List;

public interface SysRoleService {

    /**
     * 基于条件查询角色信息
     * @param entity 封装了查询条件的对象
     * @return 查询到的角色信息
     */
    List<SysRole> selectRoles(SysRole entity);

    /**
     * 新增角色以及角色对应的菜单关系数据
     * @param entity 封装了要新增的角色信息
     * @return
     */
    int insertRole(SysRole entity);
    /**
     * 基于角色id查询角色以及角色对应菜单关系数据
     * @param id
     * @return
     */
    SysRole selectById(Integer id);

    /**
     * 基于角色id更新角色以及角色对应的菜单关系数据
     * @param entity
     * @return
     */
    int updateRole(SysRole entity);

    /**
     * 为用户授权时，查询可授权的角色
     * @return
     */
    List<CheckBox> selectCheckRoles();

}
