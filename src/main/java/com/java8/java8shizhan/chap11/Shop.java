package com.java8.java8shizhan.chap11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author:chenjinfeng
 * @date: 2018/8/26
 * @time: 16:48
 * @desc
 */
public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getName() {
        return name;
    }

    public Random getRandom() {
        return random;
    }

    /**
     * 1秒的延时
     */
    private void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 同步调用
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPrice2(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    /**
     * 异步调用
     */
    public Future<Double> getPriceAsync(String product) {
        //创建CompletableFuture对象，它会包含计算的结果
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        //在另一个线程中一异步方式执行计算
        new Thread(() -> {
            try {
                //如果价格计算正常结束，完成Future操作并设置商品价格
                double price = calculatePrice(product);
                //需要长时间计算的任务结束并得出结果时，设置Future的返回值
                completableFuture.complete(price);
            } catch (Exception e) {
                //否则就抛出导致失败的异常，完成这次Future操作，抛出异常
                completableFuture.completeExceptionally(e);
            }
        }).start();
        //无需等待还没有结束的计算，直接返回Future对象
        return completableFuture;
    }

    /**
     * getPriceAsync改造，生产者方法会交由ForkJoinPool池中的某个执行线程执行
     * 生产者方法
     */
    public Future<Double> getPriceAsync2(String product) {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> calculatePrice(product));
        return future;
    }
}
