package com.concurrentpractice.chapter5;

import com.design.patterns.chapter29.enhanced.Product;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试预初始化
 *
 * @author cjf on 2020/3/30 15:23
 */
public class PreLoader {
    private final FutureTask<Product> future = new FutureTask<>(new Callable<Product>() {
        @Override
        public Product call() throws Exception {
            return loadProductInfo();
        }
    });
    private final Thread thread = new Thread(future);

    private Product loadProductInfo() {
        return null;
    }

    public void start() {
        thread.start();
    }

    public Product get() throws ExecutionException, InterruptedException {
        return future.get();
    }
}
