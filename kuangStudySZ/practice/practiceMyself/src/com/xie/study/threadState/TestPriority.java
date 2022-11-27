package com.xie.study.threadState;
//测试线程的优先级 优先 大多数的时候 优先级高的先跑 先执行 也看cpu调度，如果优先级低的先执行
//会导致 性能倒置，这种情况比较少
public class TestPriority extends Thread{
    public static void main(String[] args) {
        //主线程默认优先级
        //main 线程优先级为 5
        System.out.println(Thread.currentThread().getName()+"----"+Thread.currentThread().getPriority());

        MyPriority mypriority =new MyPriority();

        Thread t1=new Thread(mypriority);
        Thread t2=new Thread(mypriority);
        Thread t3=new Thread(mypriority);
        Thread t4=new Thread(mypriority);
        Thread t5=new Thread(mypriority);
        Thread t6=new Thread(mypriority);
        //先设置优先级 再启动
        //t1 默认的优先级 5
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();
        //最大优先级 10
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        t5.setPriority(8);
        t5.start();

        t6.setPriority(7);
        t6.start();
    }


}

class MyPriority implements Runnable{

    @Override
    public void run() {
        //打印线程的名字和 优先级
        System.out.println(Thread.currentThread().getName()+"----"+Thread.currentThread().getPriority());
    }
}
