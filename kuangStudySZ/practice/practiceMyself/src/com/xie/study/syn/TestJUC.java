package com.xie.study.syn;


import java.util.concurrent.CopyOnWriteArrayList;

//测试JUC安全类型的集合 juc并发包
public class TestJUC {
    public static void main(String[] args) {
        //线程安全的
        CopyOnWriteArrayList<String> list =new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
