package com.cy.jt.system.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserRoleDao {
    @Delete("delete from sys_user_roles where user_id=#{userId}")
    int deleteByUserId(Integer userId);

    @Select("select role_id from sys_user_roles where user_id=#{userId}")
   List<Integer> selectRoleIdsByUserId(Integer userId);

    int insertUserRoles(Integer userId, List<Integer> roleIds);

}
