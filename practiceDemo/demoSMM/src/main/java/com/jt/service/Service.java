package com.jt.service;

import com.jt.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface Service {
    void addUser(User user);
    List<User> get();

    User getUserById(Integer id);
}
