package com.concurrentpractice.completableFuture;

import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 描述or汇聚关系
 * 主要是applyToEither、acceptEither和runAfterEither系列的 接口，这些接口的区别也是源自fn、consumer、action这三个核心参数不同。
 *
 * @author cjf on 2020/4/27 17:04
 */
public class Demo3 {

    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            int t = getRandom(5, 10);
            sleep(t, TimeUnit.SECONDS);
            return String.valueOf(t);
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            int t = getRandom(5, 10);
            sleep(t, TimeUnit.SECONDS);
            return String.valueOf(t);
        });
        CompletableFuture<String> f3 = f1.applyToEither(f2, s -> s);
        System.out.println(f3.join());
    }

    private static void sleep(int t, TimeUnit seconds) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int getRandom(int i, int i1) {
        return RandomUtil.randomInt(i, i1);
    }
}
