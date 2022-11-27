package com.xie.demo2;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        //要代理谁？
        proxy.setUserService(userService);
        proxy.add();
    }
}
