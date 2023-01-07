package com.xie.threadbase;

/**
 * Author:Eric
 * DATE:2023/1/7-12:44
 * Decription: 线程的等待唤醒机制，基于wait notify来实现
 * 缺点：依赖synchronized 在这个代码块中使用
 *     notify通知，没有绑定线程参数，一般会用notifyAll
 */
public class WaitDemo {
    private static Object lock = new Object();
    private static boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (flag) {
                        try {
                            System.out.println("wait start =====");
                            //wait（）方法会释放锁资源 被唤醒后重新进入就绪状态
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("wait end =====");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if(flag) {
                    synchronized (lock) {
                        if(flag){
                            //一般用notifyAll
                            lock.notifyAll();
                            System.out.println("notify =====");
                            flag=false;
                        }
                    }
                }
            }
        }).start();
    }
}
