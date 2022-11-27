package com.xie.service;

import com.xie.entity.User;

/**
 * Author:Eric
 * DATE:2022/11/13-9:22
 * Decription: 业务层 的接口
 */
public interface IUserService {
    User select(Integer id) throws Exception;
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(Integer id) throws Exception;
}
