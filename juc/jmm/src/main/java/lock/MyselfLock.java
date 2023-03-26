package lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Author:Eric
 * DATE:2023/3/26-17:08
 * Decription: 基于AQS自定义一把锁
 * 实现的是一把独占锁
 */
public class MyselfLock extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int unused) {
        //cas 实现加锁逻辑 默认 state =0 ,
        if(compareAndSetState(0,1)){
            //将当前的线程进行绑定，设置为一个独占的线程
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int unused) {
        //释放锁
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }
    public void lock(){
        acquire(1);
    }
    public boolean tryLock(){
        return tryAcquire(1);
    }
    public void unlock(){
        release(1);
    }

}















