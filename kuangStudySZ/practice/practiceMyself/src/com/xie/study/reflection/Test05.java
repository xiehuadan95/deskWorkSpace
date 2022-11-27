package com.xie.study.reflection;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.xie.study.reflection.User");

//        User user = new User();
//        c1=user.getClass();

        //获得类的名字
        System.out.println(c1.getName());
        //获得简单名字
        System.out.println(c1.getSimpleName());
        //类的属性 只能找到public
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //因为有私有的 能找到全部的
        Field[] fields1 = c1.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
        //获得指定属性的值
        /*Field name = c1.getField("name");
        System.out.println(name);*/
        //上面的无法获得私有的
        Field name1 = c1.getDeclaredField("name");
        System.out.println(name1);

        //获得奔雷机器父类的全部public方法
        System.out.println("获得正常的方法");
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("正常的"+method);
        }
        //获得本类所有的方法包括私有的

        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        //获得指定的方法
        Method getName = c1.getMethod("getName", null);
        System.out.println(getName);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);
        //获得指定的构造器 获得public的
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        //获得本类所有的
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("++=="+declaredConstructor);
        }
    }
}
