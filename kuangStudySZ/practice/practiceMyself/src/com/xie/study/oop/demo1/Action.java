package com.xie.study.oop.demo1;

//abstract抽象类 extends:单继承  用接口可以多继承
//抽象类的所有方法，继承了它的子类就必须要实现它的方法 除非它的子类也是抽象类
public abstract class Action {

    //抽象方法 只有方法名字 没有实现
    public abstract void doSomething();
    //1.不能new 抽象类，只能由子类去实现它
    //抽象方法必须在抽象类中
    //抽象类中可以写普通方法
    public void run(){
        System.out.println("我是普通方法");
    }


}
