package lock;

/**
 * Author:Eric
 * DATE:2023/1/31-21:14
 * Decription: 实验synchronized 线程争抢及释放锁唤醒线程的顺序，QMode策略
 */
public class SyncQModeDemo {
    public static void main(String[] args) throws InterruptedException {
        SyncQModeDemo demo = new SyncQModeDemo();
        demo.startThreadA();
        //控制线程执行时间
        Thread.sleep(100);
        demo.startThreadB();
        Thread.sleep(100);
        demo.startThreadC();

    }

    final Object lock= new Object();
    private void startThreadA(){
        new Thread(()->{
            synchronized (lock){
                System.out.println("A get Lock");
                try {
                    Thread.sleep(300);
//                    lock.wait(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A release Lock");
            }
        },"thread-A").start();
    }
    private void startThreadB() {
        new Thread(()->{
            synchronized (lock){
                try {
                    System.out.println("B get Lock");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B release Lock");
            }
        },"thread-B").start();
    }
    private void startThreadC(){
        new Thread(()->{
            synchronized (lock){
                System.out.println("C get Lock");
            }
        },"thread-C").start();
    }
}
