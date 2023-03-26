package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Eric
 * DATE:2023/3/26-17:48
 * Decription: 使用ReentrantLock的使用示例
 */
public class ReentrantLockDemo {
  private static int sum=0;
  private static Lock lock= new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread= new Thread(()->{
                //加锁
                lock.lock();
                try {
                    for (int j = 0; j < 10000; j++) {
                        //有读有写 不能保证线程安全
                        sum++;
                    }
                } finally {
                    //一定手动 解锁
                    lock.unlock();
                }
            });
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println("结果："+sum);
    }

}
