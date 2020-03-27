package com.thread.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo2 {

    public static final Object lock = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        LockSupport.unpark(t1);
        System.out.println("unpark invoked");
    }

    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("in " + getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(getName() + "被中断了");
                }
                System.out.println(getName() + "继续执行");
            }
        }
    }
}

































