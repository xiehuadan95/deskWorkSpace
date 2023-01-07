package com.xie.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author:Eric
 * DATE:2022/12/25-11:13
 * Decription: 使用线程池的方式去执行程序,循环10万次往list中放入数据
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        Long start =System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        //java自带的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //这里也创建了10w个对象，但是这里只创建了两个线程
        for (int i = 0; i < 100000; i++) {
            executorService.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            list.add(random.nextInt());
                        }
                    }
            );
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        //用25毫秒
        System.out.println("花费时间："+(System.currentTimeMillis()-start));
        System.out.println("list大小："+list.size());
    }
}
