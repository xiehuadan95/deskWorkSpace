package com.xie.dao;

import com.xie.entity.User;

/**
 * Author:Eric
 * DATE:2022/11/13-9:24
 * Decription: 数据访问层的接口 声明数据访问层的具体方法
 */
public interface IUserDao {
    User select(Integer id) throws Exception;
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(Integer id) throws Exception;
}
