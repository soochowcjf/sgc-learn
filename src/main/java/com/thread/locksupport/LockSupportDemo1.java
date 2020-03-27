package com.thread.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo1 {

    public static final Object lock = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        //interrupt() 会唤醒 LockSupport.park();
        t1.interrupt();
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(getName() + "被中断了");
                }
                System.out.println(getName() + "继续执行");
            }
        }
    }
}
































