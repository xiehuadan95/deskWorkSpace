package com.cy.jt.system.service.impl;

import com.cy.jt.common.exception.ServiceException;
import com.cy.jt.system.dao.SysUserDao;
import com.cy.jt.system.dao.SysUserRoleDao;
import com.cy.jt.system.domain.SysUser;
import com.cy.jt.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;



    public int updateUser(SysUser entity){
        //开启事务
        //1.参数校验(省略)
        //2.更新用户自身信息
        int rows=sysUserDao.updateUser(entity);
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        //3.更新用户和角色关系数据
        sysUserRoleDao.deleteByUserId(entity.getId());
        sysUserRoleDao.insertUserRoles(entity.getId(),
                entity.getRoleIds());
        return rows;
    }

    public SysUser selectById(Integer id){
        SysUser user=sysUserDao.selectById(id);
        if(user==null)
            throw new ServiceException("此用户可能已经不存在");
        List<Integer> roleIds=sysUserRoleDao.selectRoleIdsByUserId(id);
        user.setRoleIds(roleIds);
        return user;
    }


    public int insertUser(SysUser entity){
        //产生一个随机字符串作为加密盐使用
        String salt= UUID.randomUUID().toString();
        //对密码进行MD5盐值加密(MD5特点:不可逆,相同内容加密结果也相同)
       String hashedPassword=
        DigestUtils.md5DigestAsHex((entity.getPassword()+salt).getBytes());
        entity.setSalt(salt);
        entity.setPassword(hashedPassword);
        int rows=sysUserDao.insertUser(entity);
        sysUserRoleDao.insertUserRoles(
                entity.getId(),entity.getRoleIds());
        return rows;
    }

    public int validById(Integer id,Integer valid){
        int rows=sysUserDao.validById(id,valid,null);
        if(rows==0)throw new ServiceException("记录可能已经不存在");
        return rows;
    }


    public List<SysUser> selectUsers(SysUser sysUser){
        return sysUserDao.selectUsers(sysUser);
    }

}
