package com.xie.threadbase;

import java.util.concurrent.locks.LockSupport;

/**
 * Author:Eric
 * DATE:2023/1/7-13:24
 * Decription: LockSupport 唤醒
 */
public class LockSupportDemo {
    static class ParkThread implements Runnable{

        @Override
        public void run() {
            System.out.println("ParkThread 开始执行");
            //线程‘停车’ 等待许可
            LockSupport.park();
            System.out.println("ParkThread 执行完成");
        }
    }
    public static void main(String[] args) {
        Thread parkThread = new Thread(new ParkThread());
        parkThread.start();
        System.out.println("唤醒parkThread====");
        //为指定线程parkThread提供许可
        LockSupport.unpark(parkThread);

    }
}
