package com.thread.thread_t9.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock需要显示地获取和释放锁，繁琐能让代码更灵活
 * Synchronized不需要显示地获取和释放锁，简单
 * <p>
 * 使用Lock可以方便的实现公平性
 * <p>
 * 非阻塞的获取锁
 * 能被中断的获取锁
 * 超时获取锁
 */
public class Sequence {

    //创建一把锁,必须使用同一把锁
    Lock lock1 = new ReentrantLock();
    private int value;

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public Integer getNext() {
        lock1.lock();
        int i = value++;
        lock1.unlock();
        return i;
    }
}
