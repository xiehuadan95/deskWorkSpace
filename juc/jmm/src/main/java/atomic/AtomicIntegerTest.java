package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:Eric
 * DATE:2023/1/7-17:18
 * Decription: 原子操作，cas
 */
public class AtomicIntegerTest {
    static AtomicInteger sum=new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    //原子 自增 cas
                    sum.incrementAndGet();
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum.get());

    }
}
