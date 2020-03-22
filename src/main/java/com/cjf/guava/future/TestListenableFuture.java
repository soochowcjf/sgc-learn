package com.cjf.guava.future;

import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cjf on 2020/3/21 15:11
 */
public class TestListenableFuture {

    @Test
    public void fun() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5, new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "NettyClientPublicExecutor_" + this.threadIndex.incrementAndGet());
            }
        });
        ListeningExecutorService listenExecutor = MoreExecutors.listeningDecorator(executor);
        // 开始使用guava的异步回调
        ListenableFuture<String> listenFuture = listenExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "hello";
            }
        });
        // 获取回调结果
        Futures.addCallback(listenFuture, new FutureCallback<String>() {

            @Override
            public void onSuccess(String result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {

            }

        }, listenExecutor);


        Thread.sleep(10000);
    }
}
