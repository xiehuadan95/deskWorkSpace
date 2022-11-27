package com.cy.jt.system.dao;

import com.cy.jt.system.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysUserDao {
    /**
     * 分页查询用户以及用户对应部门相关信息
     * @param entity 封装了查询条件的对象
     * @return 查询到的用户信息,表中的一行记录映射为内存中一个SysUser对象
     */
    List<SysUser> selectUsers(SysUser entity);

    /**
     * 禁用启用操作
     * @param id
     * @param valid
     * @param modifiedUser
     * @return
     */
    @Update("update sys_users set valid=#{valid},modifiedTime=now(),modifiedUser=#{modifiedUser} where id=#{id}")
    int validById(Integer id,Integer valid,String modifiedUser);

    /**
     * 保存用户自身信息(用户信息中密码要求是已加密的密码)
     * @param entity
     * @return
     */
    int insertUser(SysUser entity);

    /**
     * 基于id查询用户信息
     * @param id
     * @return
     */
    SysUser selectById(Integer id);
    /**
     * 更新用户自身信息(这里的更新不更新密码)
     * @param entity
     * @return
     */
    int updateUser(SysUser entity);

}
