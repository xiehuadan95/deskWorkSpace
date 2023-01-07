package com.xie.threadbase;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;

/**
 * Author:Eric
 * DATE:2023/1/2-12:00
 * Decription:
 */

@Slf4j
public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        //给线程通过runnable添加一个任务  进入阻塞状态
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //让线程进入waiting 状态
                LockSupport.park();
            }
        });
        thread.yield();
        thread.start();
        log.debug("线程名字：{},线程状态：{}", thread.getName(), thread.getState());
        thread.start();
        log.debug("线程名字：{},线程状态：{}", thread.getName(), thread.getState());
        Thread.sleep(100);
        log.debug("线程名字：{},线程状态：{}", thread.getName(), thread.getState());
        class CallableTask implements Callable<Integer> {

            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        }
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //提交任务，并用Future提交返回结果
        Future<Integer> future = service.submit(new CallableTask());

        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }

}
