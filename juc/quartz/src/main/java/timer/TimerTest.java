package timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author:Eric
 * DATE:2023/1/16-21:08
 * Decription: Timer
 * TaskQueue 小顶堆，存放timeTask
 * 单线程执行任务，任务有可能相互阻塞
 * 运行时异常会导致timer线程终止
 *
 */
public class TimerTest {
    public static void main(String[] args) {
        //定时器  任务已经启动
        Timer t =new Timer();
        //添加多个任务
        for (int i = 0; i < 2; i++) {
            TimerTask task=new FooTimerTask("foo"+i);
            //启动任务 立刻启动  2秒间隔时间 实际启动时间还取决于实际执行时间  这一步是任务添加
            t.schedule(task,new Date(),2000);
            //单线程 会存在任务阻塞 任务超时
        }
    }

}

//业务逻辑类  继承自TimerTask  TimerTask又实现了Runnable 所以需要重写run方法
class  FooTimerTask extends TimerTask {

  private String name;

    public FooTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("name:"+name+",startTime:"+new Date());
            //任务执行三秒
            Thread.sleep(3000);
            System.out.println("name:"+name+",endTime:"+new Date());
            //可以写线程池
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}