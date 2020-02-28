package com.thread.thread_t8.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 测试原子类  嘻嘻嘻 哈哈哈
 */
public class Sequence {

    private AtomicInteger value = new AtomicInteger(0);
    private int[] arr = {2, 4, 5, 6};
    private AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
    private AtomicReference<User> ref = new AtomicReference();
    private AtomicIntegerFieldUpdater<User> age = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

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

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }

    public Integer getNext() {
//        return value.getAndIncrement();//相当于i++
//        value.getAndAdd(10); 每次加10
//        return atomicIntegerArray.getAndIncrement(2);
//        return atomicIntegerArray.getAndAdd(1,3);
        User user = new User();
        age.getAndIncrement(user);
        System.out.println(user.getAge());
        return user.getAge();

    }
}
