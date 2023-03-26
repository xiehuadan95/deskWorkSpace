package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Eric
 * DATE:2023/3/26-18:03
 * Decription: ReentrantLock可中断使用示例 线程协作
 */
public class ReentrantLockInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock =new ReentrantLock();
        Thread t1 = new Thread(()->{
            System.out.println("t1---start---");
            try {
                lock.lockInterruptibly();
                try {
                    System.out.println("t1获取到了锁");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
               e.printStackTrace();
                System.out.println("t1 等待锁的过程中被中断");
            }
        },"t1");

        lock.lock();
        try {
            System.out.println("main线程获取了锁");
            t1.start();
            //先让线程t1执行
            Thread.sleep(1000);
            t1.interrupt();
            System.out.println("线程t1执行中断");
        } finally {
           lock.unlock();
        }


    }
}
