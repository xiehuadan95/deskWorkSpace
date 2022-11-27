package com.xie.security01.service;


import com.xie.security01.dao.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Fox
 */
public interface UserService extends UserDetailsService {

    User getByUsername(String username);
}
