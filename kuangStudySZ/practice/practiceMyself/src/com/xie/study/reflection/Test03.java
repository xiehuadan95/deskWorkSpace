package com.xie.study.reflection;
//测试类什么时候会初始化
public class Test03 {

    static {
        System.out.println("main被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son=new Son();
        //反射也会产生主动引用
       // Class.forName("com.xie.study.reflection.Son");

        //不会产生类的引用的方法 子类直接去调用父类的静态变量
        System.out.println(Son.b);
        Son[] array=new Son[5];
        //常量不会触发初始化
        System.out.println(Son.n);



    }
}
class Father{
    static {
        System.out.println("父类被加载");
    }
    static int b=2;
}
class Son extends Father{
    static {
        System.out.println("子类被加载");
        m=300;
    }
    static int m=100;
    static final int n=1;
}
