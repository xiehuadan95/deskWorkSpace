package com.xie.threadbase;

/**
 * Author:Eric
 * DATE:2023/1/7-10:42
 * Decription: 中断机制
 * interrupt(),将线程的中断标志位设置为true,不会停止线程
 * isinterrupted(),判断当前线程的中断标志位是否为true,不会清除中断标志位
 * Thread.interrupted():静态方法，判断当前线程中断标志位是否为true，并清除中断标志位重置为false
 */
public class ThreadInterruptTest {
    static int i=0;

    public static void main(String[] args) {
        System.out.println("程序启动-----");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    i++;
                    System.out.println(i);
                    //用sleep方法会抛出中断异常  这里休眠5秒
                    //这里 会感知到中断异常 会清掉中断标志位
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    Thread.currentThread().interrupt();
                    //静态方法，判断当前线程中断标志位是否为true，并清除中断标志位重置为false 生效一次
//                    Thread.interrupted();
                    //不会清除中断标志位
                    //Thread.currentThread().isInterrupted();
                    if(Thread.interrupted()){
                        System.out.println("线程："+Thread.currentThread()+"的中断标志位为true=====");
                    }
                    if(i==10){
                        break;
                    }
                }
            }
        });
        t.start();
        //不会停止线程t,只会设置一个中断标志位 flag =true
        t.interrupt();
    }
}
