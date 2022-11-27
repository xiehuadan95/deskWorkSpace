package com.xie.study.thread;
//创建线程方式2 实现runnable接口 创协run 执行线程需要放入runnable接口实现类

public class TestRunnable implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 200; i++) {
            System.out.println("-----我在看代码----"+i);
        }
    }
    //主线程
    public static void main(String[] args) {
        //创建一个runnable接口的实现类对象
        TestRunnable testRunnable = new TestRunnable();
        //创建线程对象，通过线程对象来开启我们的线程 代理 构造器可以接收相应的内容
       new Thread(testRunnable).start();


        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程=========="+i);
        }
    }
}

