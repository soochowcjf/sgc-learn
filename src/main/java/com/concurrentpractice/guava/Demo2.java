package com.concurrentpractice.guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cjf on 2020/5/12 19:44
 */
public class Demo2 {
    public static void main(String[] args) {
        //限流器流速：2个请求/秒
        SimpleLimiter simpleLimiter = new SimpleLimiter();
        //执⾏任务的线程池
        ExecutorService es = Executors.newFixedThreadPool(5);
        //记录上⼀次执⾏时间
        var ref = new Object() {
            long prev = System.nanoTime();
        };
        //测试执⾏20次
        for (int i = 0; i < 20; i++) {
            //限流器限流
            simpleLimiter.acquire();
            //提交任务异步执⾏
            es.execute(() -> {
                long cur = System.nanoTime();
                //打印时间间隔：毫秒
                System.out.println((cur - ref.prev) / 1000_000);
                ref.prev = cur;
            });
        }
        es.shutdown();
    }
}
