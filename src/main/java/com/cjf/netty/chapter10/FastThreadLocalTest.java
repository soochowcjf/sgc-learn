package com.cjf.netty.chapter10;

import io.netty.util.concurrent.FastThreadLocal;
import org.junit.Test;

/**
 * created by cjf 21:41 2018/11/22
 */
public class FastThreadLocalTest {

    private static FastThreadLocal<Object> fastThreadLocal = new FastThreadLocal<Object>() {
        //第一次调用FastThreadLocal.get()的时候，会执行该initialValue()方法
        @Override
        protected Object initialValue() throws Exception {
            return new Object();
        }
    };

    private static FastThreadLocal threadLocal = new FastThreadLocal();

    @Test
    public void test1() {
        new Thread(() -> System.out.println(threadLocal)).start();

        new Thread(() -> System.out.println(threadLocal)).start();
        /**
         * io.netty.util.concurrent.FastThreadLocal@176bcb6
         * io.netty.util.concurrent.FastThreadLocal@176bcb6
         */
    }

    @Test
    public void test2() {
        new Thread(() -> {
            Object object = fastThreadLocal.get();
            System.out.println(object);
        }).start();

        new Thread(() -> {
            Object object = fastThreadLocal.get();
            System.out.println(object);
        }).start();
        /**
         * java.lang.Object@7070ec
         * java.lang.Object@1adb8ad
         */
    }

    @Test
    public void test3() {
        new Thread(() -> {
            Object object = fastThreadLocal.get();
            System.out.println(object);
            while (true) {
                System.out.println(fastThreadLocal.get() == object);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            Object object = fastThreadLocal.get();
            System.out.println(object);
            while (true) {
                threadLocal.set(new Object());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        //只要主线程结束，整个程序将会退出，这就是采用junit的时候奇怪退出程序的原因。
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * java.lang.Object@10fe492
         * java.lang.Object@17c931
         * true
         * true
         * true
         * true
         */
    }
}
