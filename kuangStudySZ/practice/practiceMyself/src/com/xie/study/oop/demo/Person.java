package com.xie.study.oop.demo;
//无法被继承
public final class  Person {
    {
        //2.代码块（匿名） 可以赋一些初始值
        System.out.println("匿名代码块");
    }
    static {
        //1.静态代码块 加载执行 只执行一次
        System.out.println("静态代码块");

    }
    //3.
    public Person(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("----------");
        Person person2 = new Person();
    }


}
