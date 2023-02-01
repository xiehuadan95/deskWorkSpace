package pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author:Eric
 * DATE:2023/1/17-21:45
 * Decription:  定时任务线程池 多线程执行 不会阻塞
 * 多线程去执行的，一共执行两个任务
 */
public class ScheduleThreadPoolTest {

    public static void main(String[] args) {
        //核心线程数
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //其实就是核心线程数设定为1
        //Executors.newSingleThreadScheduledExecutor();
        //建两个任务
        for (int i = 0; i < 2; i++) {
            //放入任务 要么是Runnable Callable的实例
            //delay:延迟时间    时间单位  任务只能执行一次
//            scheduledThreadPool.schedule(new Task("task-"+i),2, TimeUnit.SECONDS);
            //
            scheduledThreadPool.scheduleAtFixedRate(new Task("task-"+i),0,2,TimeUnit.SECONDS);
        }
    }
}
class Task implements Runnable{
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {
            System.out.println("name ="+name+",startTime ="+new Date());
            Thread.sleep(1000);
            System.out.println("name ="+name+",endTime ="+new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

