package lock;

/**
 * Author:Eric
 * DATE:2023/1/15-16:44
 * Decription: 通过在方法上面加锁

 */
public class SyncDemo1 {
    //临界资源
    private static int counter = 0;

    //临界区  对临界区代码加了一把锁 会出现： 线程访问 counter++的时候，其他线程无法访问counter-- ,只有释放以后才可以
    //通过互斥 达到目的
    public static synchronized void increment() {
        counter++;
    }

    //临界区
    public static synchronized void decrement() {
        counter--;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 5000; i++) {
                increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                decrement();
            }
        }, "t2");
        t1.start();
        t2.start();
        //t1 t2执行完以后 main线程再执行
        t1.join();
        t2.join();
        System.out.println("静态变量counter的值：" + counter);
    }
}
