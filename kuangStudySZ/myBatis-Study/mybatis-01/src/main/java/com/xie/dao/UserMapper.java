package com.xie.dao;

import com.xie.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    //模糊查询
    List<User> getUserLike(String value);

    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);
    //用map
    User getUserById2(Map<String,Object> map);
    //insert
    int addUser(User user);
    //用map传
    int addUser2(Map<String,Object> map);
    //修改用户
    int updateUser(User user);
    //删除一个用户
    int deleteUser(int id);

}
