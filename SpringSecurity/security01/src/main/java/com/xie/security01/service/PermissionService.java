package com.xie.security01.service;



import com.xie.security01.dao.Permission;

import java.util.List;

/**
 * @author Fox
 */
public interface PermissionService  {

    List<Permission> selectByUserId(Long userId);
}
