package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Eric
 * DATE:2023/3/26-18:24
 * Decription: ReentrantLock 公平/非公平锁示例
 */
public class ReentrantLockDemo5 {
    public static void main(String[] args) throws InterruptedException {
        //公平锁，后续进来的线程都会老实排队
//        ReentrantLock lock = new ReentrantLock(true);
        //非公平
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                lock.lock();
                try{
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" running...");
                }finally {
                    lock.unlock();
                }
            },"t"+i).start();
        }
        //1秒后去争抢锁
        Thread.sleep(1000);
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+" running...");
                } finally {
                    lock.unlock();
                }
            },"强行插入 "+i).start();
        }
    }
}
