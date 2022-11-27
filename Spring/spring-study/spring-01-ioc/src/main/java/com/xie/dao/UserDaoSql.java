package com.xie.dao;

public class UserDaoSql implements UserDao{
    @Override
    public void getUser() {
        System.out.println("我是DaoSql");
    }
}
