package com.xie.study.threadState;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

//观察测试线程的状态
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("******");

        });

        //观测状态
        Thread.State state = thread.getState();
        System.out.println(state);
        //观察启动后
        thread.start();
        state=thread.getState();
        System.out.println(state+"Run");
        //只要线程不终止 就一直输出状态
        while(state!=Thread.State.TERMINATED){
            Thread.sleep(100);
            //更新线程状态
            state =thread.getState();
            System.out.println("输出状态"+state);
        }
        //线程停止（死亡）后 是不能再启动的 线程只能启动一次
        //thread.start();
    }


}
