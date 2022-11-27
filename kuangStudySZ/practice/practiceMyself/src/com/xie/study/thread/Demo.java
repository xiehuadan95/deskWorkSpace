package com.xie.study.thread;

//process进程  Thread线程 创建线程方式一：继承Thread类 重写run()方法，调用start开启方法

//线程开启 不一定立即执行 由CPU调度
public class Demo extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码========"+i);
        }
    }
        //主线程
    public static void main(String[] args) {
        //创建一个线程对象
        Demo demo = new Demo();
        //调用start 方法开启线程 多线程执行，cpu调度安排走哪一个线程
        demo.start();
        //run方法 先走run方法 按照顺序来
       // demo.run();


        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程=========="+i);
        }
    }
}
