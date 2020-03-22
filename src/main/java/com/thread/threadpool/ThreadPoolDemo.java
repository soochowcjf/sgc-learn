package com.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cjf on 2020/3/22 17:06
 */
public class ThreadPoolDemo {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int COUNT_MASK = (1 << COUNT_BITS) - 1;
    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    // Packing and unpacking ctl
    private static int runStateOf(int c) {
        return c & ~COUNT_MASK;
    }

    private static int workerCountOf(int c) {
        return c & COUNT_MASK;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    public static void main(String[] args) {

        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, blockingQueue, new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "sgc_thread_" + this.threadIndex.incrementAndGet());
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 16; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println("线程池中活跃的线程数： " + threadPoolExecutor.getPoolSize());
                if (threadPoolExecutor.getQueue().size() > 0) {
                    System.out.println("----------------队列中阻塞的线程数" + threadPoolExecutor.getQueue().size());
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

    @Test
    public void fun() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(RUNNING);
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(SHUTDOWN);
        System.out.println(Integer.toBinaryString(SHUTDOWN));
        System.out.println(STOP);
        System.out.println(Integer.toBinaryString(STOP));
        System.out.println(TIDYING);
        System.out.println(Integer.toBinaryString(TIDYING));
        System.out.println(TERMINATED);
        System.out.println(Integer.toBinaryString(TERMINATED));
    }
}
