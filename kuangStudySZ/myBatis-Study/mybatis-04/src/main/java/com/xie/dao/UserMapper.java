package com.xie.dao;


import com.xie.pojo.User;

public interface UserMapper {
    //根据id查询用户
     User getUserById(int id);

}
