package com.xie.study.thread;

//多个线程同时操作同一个对象
//买火车票
//多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TestThread3 implements Runnable {
        //票数
    private  int ticketNums=10;
    @Override
    public void run() {
        //Thread.currentThread()得到当前线程，getName获得当前线程的名字 可以自己定
        while (true){
            if (ticketNums <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket =new TestThread3();
        //创建三个线程，将实现了runaable的线程对象放进去，并取好线程的名字
        new Thread(ticket,"小明").start();
        new Thread(ticket,"jack").start();
        new Thread(ticket,"rose").start();
    }

}
