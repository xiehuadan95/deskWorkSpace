package com.jt.service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class ServiceImp implements Service{
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user){
        userMapper.insert(user);
    }
    @Override
    public List<User> get(){

        return userMapper.selectList(null);
    }

    @Override
    public User getUserById(Integer id) {

        return userMapper.selectById(id);
    }
}
