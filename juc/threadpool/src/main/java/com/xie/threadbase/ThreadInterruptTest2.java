package com.xie.threadbase;

/**
 * Author:Eric
 * DATE:2023/1/7-11:47
 * Decription: 通过满足某种条件来达成中断机制
 */
public class ThreadInterruptTest2 implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //重新设置线程中断状态为true
                Thread.currentThread().interrupt();
                System.out.println("线程名："+Thread.currentThread().getName());
            }
        }
        System.out.println("线程停止：stop");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadInterruptTest2());
        thread.start();
        Thread.sleep(2);
        //给线程中断标志赋值为true
        thread.interrupt();
    }
}
