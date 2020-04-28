package com.concurrentpractice.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 异常处理
 *
 * @author cjf on 2020/4/27 18:17
 */
public class Demo4 {

    public static void main(String[] args) {
        CompletableFuture<Integer> f0 = CompletableFuture
                .supplyAsync(() -> (7 / 0))
                .thenApply(r -> r * 10)
                .exceptionally(e -> 0);
        System.out.println(f0.join());


    }
}
