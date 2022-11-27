package com.xie.study.oop.demo3;

public class Test {
    public static void main(String[] args) {
        //没有名字初始化类 匿名内部类,不用将实例保存到变量中
        new Apple().eat();
        new UserService(){

            @Override
            public void hello() {

            }
        };
    }
}
class Apple {
    public void eat(){
        System.out.println("1");
    }
}
interface  UserService{
    void hello();
}
