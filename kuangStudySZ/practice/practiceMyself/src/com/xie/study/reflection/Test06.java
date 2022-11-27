package com.xie.study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象 反射
public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("com.xie.study.reflection.User");
        //构造一个对象 本质上调用了user的无参构造器 才可以 必须要有一个无参构造器，类的构造器的访问权限需要足够
       // User user =(User) c1.newInstance();
       // System.out.println(user);
        //通过构造器创建对象
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        User  user2 = (User)constructor.newInstance("jack", 2, 20);
        System.out.println(user2);

        //通过反射调用方法
        User user =(User) c1.newInstance();
        Method setName = c1.getMethod("setName", String.class);
        //invoke 激活 传入这个对象，调用这个方法，传入相应的参数
        setName.invoke(user,"rose");
        //将调用set方法后的结果 get出来
        System.out.println(user.getName());

        //利用反射操作属性
       User user1 = (User)c1.newInstance();

        Field[] declaredFields = c1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要关闭程序的安全检测，通过属性或者方法的 setAccessible(true) 关掉
        name.setAccessible(true);
        //所有的方法字段构造对象都有setAccessible（）方法，关闭或者开启权限访问安全检测 true为关闭false为打开
        System.out.println(name);
        name.set(user1,"mike");
        System.out.println(user1.getName());

    }
}
