package lock;


import java.util.logging.Logger;

/**
 * Author:Eric
 * DATE:2023/3/26-17:21
 * Decription: 测试自定义实现AQS的锁
 */

public class MyselfLockTest {

    private static int sum=0;
    private static MyselfLock lock =new MyselfLock();

    public static void main(String[] args) throws InterruptedException {
//        Logger  logger = Logger.getLogger("MyselfLockTest");

        for (int i = 0; i < 3; i++) {
           Thread thread= new Thread(()->{
                //加锁
                lock.lock();
                try {
                    for (int j = 0; j < 10000; j++) {
                        //有读有写 不能保证线程安全
                        sum++;
                    }
                } finally {
                    //解锁
                    lock.unlock();
                }
            });
           thread.start();
           thread.join();
        }
        System.out.println("结果："+sum);
//        logger.info("结果："+sum);
    }

}
