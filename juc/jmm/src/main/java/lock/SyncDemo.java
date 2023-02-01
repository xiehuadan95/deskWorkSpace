package lock;

/**
 * Author:Eric
 * DATE:2023/1/15-16:44
 * Decription: java共享内存模型带来的线程安全问题
 * 两个线程对初始值为 0 的静态变量一个做自增，一个做自减，各做5000 次，结果是 0 吗？
 * 临界资源/临界区
 * 一段代码块内如果存在对共享资源的多线程读写操作，称这段代码块为临界区，其共享资源为临界资源
 */
public class SyncDemo {
    //临界资源
    private static int counter = 0;
    //临界区
    public static void increment() {
        counter++;
    }
    //临界区
    public static void decrement() {
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
