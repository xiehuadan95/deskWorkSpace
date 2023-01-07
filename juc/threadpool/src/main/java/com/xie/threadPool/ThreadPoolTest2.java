package com.xie.threadPool;

import java.util.concurrent.*;

/**
 * Author:Eric
 * DATE:2022/12/25-11:40
 * Decription: 分别用三种线程池方式去执行任务对比时间
 */
public class ThreadPoolTest2 {
    //一般不推荐用java自带工具类写线程池
    public static void main(String[] args) {
        //快
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        //比上面的慢  一共用10个线程去执行那100个任务
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        //最慢的     线程池用一个线程去执行这100个任务
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        //自定义线程池 队列指定容量10 额外多出的临时线程生命周期为1秒
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,
                1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
        //执行了100个项目 每个项目需要执行三秒，分别用这三种线程池去执行
        for (int i = 0; i < 100; i++) {
//            executorService1.execute(new MyTask(i));
//            executorService2.execute(new MyTask(i));
//            executorService3.execute(new MyTask(i));
            threadPoolExecutor.execute(new MyTask(i));
        }
    }
}

/**
 * 项目
 */
class MyTask implements Runnable {
    int i;
    public MyTask(int i) {
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"做的第"+i+"个项目");
        //业务逻辑执行3秒
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}