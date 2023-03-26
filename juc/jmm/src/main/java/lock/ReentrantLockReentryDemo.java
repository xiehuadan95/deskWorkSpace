package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Eric
 * DATE:2023/3/26-17:55
 * Decription: ReentrantLock重入使用示例
 */
public class ReentrantLockReentryDemo {
    private static Lock lock= new ReentrantLock();
    public static void main(String[] args) {
        method();
    }

    private static void method() {
        lock.lock();
        try {
            System.out.println("execute method");
            method1();
        } finally {
          lock.unlock();
        }
    }

    private static void method1() {
        lock.lock();
        try {
            System.out.println("execute method1");
            method2();
        } finally {
            lock.unlock();
        }
    }

    private static void method2() {
        lock.lock();
        try {
            System.out.println("execute method2");
        } finally {
            lock.unlock();
        }
    }

}
