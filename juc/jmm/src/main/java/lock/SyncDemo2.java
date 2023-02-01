package lock;

/**
 * Author:Eric
 * DATE:2023/1/15-16:44
 * Decription: 通过自定义锁对象 来达到目的
 */
public class SyncDemo2 {
    //临界资源
    private static int counter = 0;

    private static String lock = "";

    //通过互斥
    public static void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    //临界区
    public static synchronized void decrement() {
        synchronized (lock) {
            counter--;
        }
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
