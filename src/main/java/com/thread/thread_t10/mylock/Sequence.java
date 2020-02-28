package com.thread.thread_t10.mylock;

import java.util.concurrent.locks.Lock;

public class Sequence {

    //创建一把锁,必须使用同一把锁
    Lock lock1 = new Mylock();
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
