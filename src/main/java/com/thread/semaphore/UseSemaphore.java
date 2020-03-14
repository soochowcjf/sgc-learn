package com.thread.semaphore;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class UseSemaphore {


    public static void main(String[] args) {

        // 线程池  
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        //模拟实际业务逻辑
                        Thread.sleep((long) (Math.random() * 10000));
                        // 访问完后，释放
                        semp.release();
                    } catch (InterruptedException e) {
                    }
                }
            };
            exec.execute(run);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(semp.getQueueLength());
        // 退出线程池
        exec.shutdown();
    }


    public static int getHeaderLength(int length) {
        return length & 0xFFFFFF;
    }

    @Test
    public void fun() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.class.getCanonicalName());
        System.out.println(double.class.getCanonicalName());
        System.out.println(1 << 0);

        byte[] bytes = new byte[9];
        bytes[8] = 3;
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        int length = byteBuffer.limit();
        int oriHeaderLen = byteBuffer.getInt();
        int headerLength = getHeaderLength(oriHeaderLen);

        System.out.println(length);
        System.out.println(oriHeaderLen);
        System.out.println(headerLength);
    }

    @Test
    public void fun1() {
        String addr = "192.168.25.1:80/test";
        int index = addr.lastIndexOf("/");
        if (index >= 0) {
            System.out.println(addr.substring(index + 1));
        }
    }
}  
