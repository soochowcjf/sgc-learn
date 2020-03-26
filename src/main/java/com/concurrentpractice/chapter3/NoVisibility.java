package com.concurrentpractice.chapter3;

/**
 * created by cjf 10:55 2019/1/27
 * 这段代码看起来会输出42，但事实上很可能输出0，或者根本无法终止
 * 因为读线程可能永远看不到ready的值，一种更奇怪的现象是，NoVisibility可能会输出0，因为读线程可能看到了写入的ready的值，但却没有看到写入number的值，指令重排序。
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                //线程让步
                Thread.yield();
            }
            System.out.println(number);
        }
    }
}
