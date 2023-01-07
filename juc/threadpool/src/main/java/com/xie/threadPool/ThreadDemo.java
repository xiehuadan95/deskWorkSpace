package com.xie.threadPool;

/**
 * Author:Eric
 * DATE:2022/12/31-14:27
 * Decription: 线程demo run 方法调用的本地方法，start方法调用线程执行
 */
public class ThreadDemo extends Thread{
    private String name;
    public ThreadDemo(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        //方法调用
//        new ThreadDemo("eric").run();
        //线程启动
        new ThreadDemo("lily").start();
        //线程的名字不一样
    }
}
