package com.xie.service;

import com.xie.dao.UserDao;
import com.xie.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    //private UserDao userDao=new UserDaoImpl();

    //利用set进行动态实现值的注入！
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public void getUser() {
        System.out.println("我是service层");
        userDao.getUser();
    }
}
