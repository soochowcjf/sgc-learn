package com.thread;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 测试 wait() notify() 方法
 */
public class Clock {

    private static final Object obj = new Object();
    String currentTime;

    public static void main(String[] args) {
        Clock clock = new Clock();
        TimeThread timethread = clock.new TimeThread();
        timethread.start();
        ShowThread showThread = clock.new ShowThread();
        showThread.start();
    }

    @Test
    public void fun() {
        String property = System.getProperty("os.name");
        System.out.println(property);
    }

    class ShowThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj) {
                if (currentTime == null) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("当前时间为：" + currentTime);
        }
    }

    class TimeThread extends Thread {
        @Override
        public void run() {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            currentTime = sdf.format(new Date());
            synchronized (obj) {
                obj.notify();
            }
        }
    }

}
