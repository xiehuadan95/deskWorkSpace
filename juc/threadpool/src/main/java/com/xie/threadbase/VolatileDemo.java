package com.xie.threadbase;

/**
 * Author:Eric
 * DATE:2023/1/7-12:34
 * Decription: 利用volatile的可见性 进行线程之间的通信，两个线程之间根据状态进行通信
 */
public class VolatileDemo {
    //全局变量 被volatile修饰
    private static volatile boolean flag =true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(flag){
                        System.out.println("turn on");
                        flag=false;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(!flag){
                        System.out.println("turn off");
                        flag=true;
                    }
                }
            }
        }).start();

    }
}
