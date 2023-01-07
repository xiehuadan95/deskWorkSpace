package com.xie.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author:Eric
 * DATE:2022/12/25-11:02
 * Decription: 使用线程的方式去执行程序,循环10万次往list中放入数据
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        //循环10万次 创建了 10万零一个线程
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        //用8秒
        System.out.println("花费的时间"+(System.currentTimeMillis()-start));
        System.out.println("list大小"+list.size());
    }
}

