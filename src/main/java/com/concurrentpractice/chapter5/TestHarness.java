package com.concurrentpractice.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * 测试 {@link CountDownLatch}
 *
 * @author cjf on 2020/3/30 15:07
 */
public class TestHarness {

    public long timeTakes(int nThreads, final Runnable task) throws InterruptedException {
        //起始门
        final CountDownLatch startGate = new CountDownLatch(1);
        //关闭门
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    //所有线程执行到这里，等待
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        //处理完成，释放闭锁
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            thread.start();
        }

        long start = System.nanoTime();
        //释放起始门
        startGate.countDown();
        //等待关闭门全部释放
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
