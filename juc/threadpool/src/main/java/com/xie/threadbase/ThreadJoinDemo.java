package com.xie.threadbase;

/**
 * Author:Eric
 * DATE:2023/1/7-9:09
 * Decription:  Thread 的常用方法 join底层就是等待唤醒机制
 *              在主线程中调用t线程 的join方法，此时t线程会阻塞主线程的执行
 *
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程：t---开始运行----");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程：t---运行完成");
            }
        });
        long start =System.currentTimeMillis();
        t.start();
        //主线程等待线程t执行完成 再执行
        t.join();
        System.out.println("执行时间："+(System.currentTimeMillis()-start));
        System.out.println("main线程：执行完成！");
    }
}
