package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Eric
 * DATE:2023/3/26-18:15
 * Decription: ReentrantLock 超时
 */
public class ReentrantLockOutTimeDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock =new ReentrantLock();
        Thread t1 = new Thread(()->{
            System.out.println("t1---start---");
            //超时
            try {
                //尝试获取锁 1秒后超时
               if(!lock.tryLock(1, TimeUnit.SECONDS)){
                   System.out.println("等待1s后获取锁失败，返回");
                   return;
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
               return;
            }
        },"t1");

        lock.lock();
        try {
            System.out.println("main线程获取了锁");
            t1.start();
            //先让线程t1执行
            Thread.sleep(2000);
        } finally {
            lock.unlock();
        }
    }
}
