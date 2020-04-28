package com.concurrentpractice.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 串行关系
 * CompletionStage接口里面描述串行关系，主要是thenApply、thenAccept、thenRun和thenCompose这四个系列的接口。
 *
 * @author cjf on 2020/4/27 16:55
 */
public class Demo1 {

    public static void main(String[] args) {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "Hello World")
                .thenApply(e -> e + " QQ")
                .thenApply(String::toUpperCase);

        System.out.println(stringCompletableFuture.join());
    }
}
