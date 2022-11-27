package com.xie.dao;

import com.xie.entity.User;

/**
 * Author:Eric
 * DATE:2022/11/15-21:39
 * Decription:
 */
public interface IUserDao {
    User getUser();

    void sub();

    void save();
}
