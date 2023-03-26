package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Eric
 * DATE:2023/3/26-18:43
 * Decription: ReentrantLock条件变量 示例
 */
public class ReentrantLockDemo6 {
    private static ReentrantLock lock =new ReentrantLock();
    //定义两个条件
    private static Condition cigCon = lock.newCondition();
    private static Condition takeCon=lock.newCondition();

    private static boolean hashcig =false;
    private static boolean hastakeout =false;
    //送烟
    public void cigratee(){
        lock.lock();
        try {
            while (!hashcig){
                try {
                    System.out.println("没有烟,休息--------");
                    //释放锁 进入条件队列
                    cigCon.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("有烟了,干活-----");
        } finally {
            lock.unlock();
        }
    }
    //送外卖
    public void takeout(){
        lock.lock();
        try {
            while (!hastakeout){
                try {
                    System.out.println("没有饭,休息------");
                    //一个没有饭的条件 带有一个条件队列
                    takeCon.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("有饭了,干活-----");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantLockDemo6 test = new ReentrantLockDemo6();
        new Thread(()->{
            test.cigratee();
        }).start();
        new Thread(()->{
            test.takeout();
        }).start();

        new Thread(()->{
            lock.lock();
            try {
                hashcig=true;
                System.out.println("唤醒送烟的等待线程------！");
                cigCon.signal();
            }finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            lock.lock();
            try {
                hastakeout=true;
                System.out.println("唤醒饭的等待线程------！");
                takeCon.signal();
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
