package com.xie.study.threadState;
//测试守护线程  虚拟机不需要等待守护线程执行完毕
public class TestDaemon {
    public static void main(String[] args) {
        God god=new God();
        You you=new You();

        Thread thread=new Thread(god);
        //默认是false 表示是用户线程，正常的线程都是用户线程
        thread.setDaemon(true);
        //守护线程启动
        thread.start();
        //用户线程启动
        new Thread(you).start();

    }

}
//上帝
class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("上帝保佑你");
        }
    }
}

//你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("一生都开心的活着");
        }
        System.out.println("goodbye! world!1");
    }
}