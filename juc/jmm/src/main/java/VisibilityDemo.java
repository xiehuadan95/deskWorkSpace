import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Author:Eric
 * DATE:2022/11/28-15:36
 * Decription: 并发可见性示例
 */
public class VisibilityDemo {
    //线程的共享变量
    private   boolean flag=true;
    //如果是  Integer 且有使用，会实现可见性
    private  int count=0;
    //模拟程序正在执行的方法
    public final void load(){
        System.out.println("程序开始加载=====");
        while (flag){
            //TODO 业务逻辑
           // getUnsafe().storeFence();
           // Thread.yield();
          // System.out.println(count);
        count++;
        //1毫秒
        shortWait(1000000);
            //1微秒 不会过期 这个时间不确定
//            shortWait(1000);
        }
        System.out.println("线程："+Thread.currentThread().getName()+"执行完成,跳出循环"+count);
    }
    //修改共享变量
    public  void refresh(){
        flag=false;
        System.out.println("线程："+Thread.currentThread().getName()+"对变量flag进行修改,flag:"+flag);
    }
    //内存屏障
    public Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //模拟执行时长
    public static void shortWait(long interval){
        //获取纳秒
        long start =System.nanoTime();
        long end;
        do{
            end=System.nanoTime();
        }while (start+interval>=end);
    }
    public static void main(String[] args) throws InterruptedException {
        //创建对象
        VisibilityDemo test = new VisibilityDemo();
        Thread threadA = new Thread(()->test.load(),"threadA");
        threadA.start();
        //main线程休眠一秒 再往下走
        Thread.sleep(1000);
        //B线程对共享变量进行修改 打断A线程的循环
        Thread threadB = new Thread(() -> test.refresh(), "threadB");
        threadB.start();
    }
}
