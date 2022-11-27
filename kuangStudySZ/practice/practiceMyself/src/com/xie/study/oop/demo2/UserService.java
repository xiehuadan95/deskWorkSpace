package com.xie.study.oop.demo2;

//接口都有实现类 相当于一个约束
public interface UserService {
    //定义所有的属性都是 常量 public static final 一般不会去定义常量
    int AGE=99;

    //接口中所有的定义都是 public abstract !!
    void run(String name);
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);

}
