package com.cy.jt.system.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMenuDao {
    @Delete("delete from sys_role_menus where role_id=#{roleId}")
    int deleteByRoleId(Integer roleId);

    int insertRoleMenus(Integer roleId, List<Integer> menuIds);

}
