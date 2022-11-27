package com.xie.study.threadState;

//vip插队 测试join方法
public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("线程VIP来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin=new TestJoin();
        Thread thread=new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 300; i++) {
            if(i==200){
                //插队
                thread.join();
            }
            System.out.println("main"+i);
        }
    }
}
