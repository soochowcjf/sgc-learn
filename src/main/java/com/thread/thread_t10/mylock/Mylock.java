package com.thread.thread_t10.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义Lock,可重入
 */
public class Mylock implements Lock {

    private boolean isLock = false;     //定义一个标志位
    private Thread lockby = null;              //定义一个线程引用
    private int lockcount = 0;              //锁的个数

    @Override
    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();//得到当前线程
        while (isLock && currentThread != lockby) {
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
        lockby = currentThread;
        lockcount++;
    }

    @Override
    public synchronized void unlock() {
        if (lockby == Thread.currentThread()) {//如果被锁的线程是当前线程
            lockcount--;
            if (lockcount == 0) {//当锁的个数为0的时候，才可以唤醒其他线程
                notify();
                isLock = false;
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
