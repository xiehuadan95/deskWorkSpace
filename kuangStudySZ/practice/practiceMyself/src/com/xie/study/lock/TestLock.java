package com.xie.study.lock;



import java.util.concurrent.locks.ReentrantLock;

//测试lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2=new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable{
    int ticketNums=10;
    //定义lock锁 可重入锁 显示的，需要手动开关，sychronized还可以锁方法，lock只能锁代码块
    //子类 可重入锁
    private final ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            //加锁
            try {
                lock.lock();
                if(ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }finally {
                //释放锁
                lock.unlock();
            }

        }
    }
}