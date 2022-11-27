package com.xie.service.impl;

import com.xie.dao.IUserDao;
import com.xie.entity.User;
import com.xie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:Eric
 * DATE:2022/11/13-9:23
 * Decription: 业务层对接口的实现类
 */
@Service
public class UserServiceImpl  implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    public User select(Integer id) throws Exception {
        System.out.println("查询User!");
        return userDao.select(id);
    }

    @Override
    public void add(User user) throws Exception {
        System.out.println("增加user!");
        userDao.add(user);
    }

    @Override
    public void update(User user) throws Exception {
        System.out.println("更新user!");
        userDao.update(user);
    }

    @Override
    public void delete(Integer id) throws Exception {
        System.out.println("删除user!");
        userDao.delete(id);
    }
}
