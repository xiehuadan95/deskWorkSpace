package com.xie.study.oop.demo3;

public class Application {
    public static void main(String[] args) {
        Outer outer=new Outer();
        //同步外部类来实例化内部类


        Outer.Inner.getId();


    }
}
