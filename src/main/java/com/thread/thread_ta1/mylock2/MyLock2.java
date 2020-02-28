package com.thread.thread_ta1.mylock2;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author:chenjinfeng
 * @Date:2018/5/20
 * @Time:15:40
 */
public class MyLock2 implements Lock, Serializable {

    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void unlock() {
        sync.tryRelease(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            //state为锁的个数
            int state = getState();
            Thread t = Thread.currentThread();
            //判断是否是第一个线程进入，如果是，可以拿到锁
            if (compareAndSetState(0, 1)) {
                //将当前线程设置为排他线程
                setExclusiveOwnerThread(t);
                return true;
                //如果进入的线程和当前线程一致
            } else if (t == Thread.currentThread()) {
                setState(state++);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            boolean flag = false;
            //判断是否是当前线程
            if (getExclusiveOwnerThread() == Thread.currentThread()) {
                //锁的个数减一
                int state = getState() - arg;
                if (state == 0) {
                    //如果全部解锁了，设置当前的线程引用为空
                    setExclusiveOwnerThread(null);
                    flag = true;
                }
                setState(state);
            }
            return flag;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }
}
