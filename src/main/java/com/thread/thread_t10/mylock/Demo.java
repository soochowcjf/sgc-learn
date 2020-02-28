package com.thread.thread_t10.mylock;

/**
 * 测试锁的重入
 */
public class Demo {

    //创建锁
    Mylock mylock1 = new Mylock();

    public static void main(String[] args) {
        Demo d = new Demo();
        //起线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.a();
            }
        }).start();
    }

    public void a() {
        mylock1.lock();
        System.out.println("a");
        b();
        mylock1.unlock();
    }

    public void b() {
        mylock1.lock();
        System.out.println("b");
        mylock1.unlock();
    }

}
