package com.xie.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Author:Eric
 * DATE:2022/11/13-9:19
 * Decription: 模拟的实体类
 */
@Component
public class User implements SmartFactoryBean<User> {
    private Integer id;
    private String username;
    private String password;

    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setUsername("factoryBean");
        return user;
    }
    @Override
    public boolean isEagerInit() {
        return SmartFactoryBean.super.isEagerInit();
    }


    public User() {
        System.out.println("user已加载");
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    @Override
    public Class<?> getObjectType() {
        return null;
    }



}
