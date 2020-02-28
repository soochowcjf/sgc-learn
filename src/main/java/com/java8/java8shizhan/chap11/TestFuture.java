package com.java8.java8shizhan.chap11;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author:chenjinfeng
 * @date: 2018/8/25
 * @time: 23:51
 * @desc
 */
public class TestFuture {


    List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("QuanJia")//添加了一个商店，为5个商店
    );
    /**
     * 使用定制的执行器
     */
    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread thread = new Thread(r);
        //使用守护线程，这种方式不会阻止程序的关停
        thread.setDaemon(true);
        return thread;
    });

    @Test
    public void fun() {
        //创建ExecutorService，通过它你可以向线程池提交任务
        ExecutorService executorService = Executors.newCachedThreadPool();
        //向ExecutorService提交一个Callable对象
        //以异步的方式在新的线程中执行耗时的操作
        Future<Double> future = executorService.submit(this::doSomeLongComputation);
        //异步操作进行的同时，你可以做其他的事情
        doSomethingElse();
        try {
            //获取异步操作的结果，如果最终被zus，无法得到结果，那么在最多等待1秒钟之后退出
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //当前线程在等待过程中中断
        } catch (ExecutionException e) {
            //计算抛出一个异常
        } catch (TimeoutException e) {
            //在Future对象完成之前超过过期时间
        }
    }

    private void doSomethingElse() {
    }

    private Double doSomeLongComputation() {
        return null;
    }

    @Test
    public void fun2() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationtime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationtime + " msecs");
        //执行更多任务，比如查询其他商店
        doSomethingElse();
        //在计算商品价格的同时
        try {
            Double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
        }
        long retrievaltime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievaltime + " msecs");
        /**
         * Invocation returned after 49 msecs
         * Price is 123.26
         * Price returned after 1051 msecs
         */
    }

    public List<String> findPrices(String product) {
//         return shops.stream()
        //使用并行流并行地从不同的商店获取价格
        return shops.parallelStream()
                .map(s -> String.format("%s price is %.2f", s.getName(), s.getPrice(product)))
                .collect(Collectors.toList());
    }

    @Test
    public void fun3() {
        long start = System.nanoTime();
//        System.out.println(findPrices("myPhone27s"));
        System.out.println(findPrices2("myPhone27s"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        /**
         * stream
         * [BestPrice price is 123.26, LetsSaveBig price is 169.47, MyFavoriteShop price is 214.13, BuyItAll price is 184.74]
         * Done in 4064 msecs  (5个商店的时候，耗时5062 msecs)
         */
        /**
         * parallelStream 并行流
         * [BestPrice price is 123.26, LetsSaveBig price is 169.47, MyFavoriteShop price is 214.13, BuyItAll price is 184.74]
         * Done in 1070 msecs   (5个商店的时候，耗时2068 msecs)
         */
        /**
         * findPrices2 CompletableFuture发起的异步请求
         * [BestPrice price is 123.25651664705744, LetsSaveBig price is 169.4653393606115, MyFavoriteShop price is 214.12914480588853, BuyItAll price is 184.74384995303313]
         * Done in 2064 msecs    (5个商店的时候，耗时2065 msecs)
         */
        /**
         * 使用定制的执行器 executor
         * [BestPrice price is 123.25651664705744, LetsSaveBig price is 169.4653393606115, MyFavoriteShop price is 214.12914480588853, BuyItAll price is 184.74384995303313, QuanJia price is 217.76654434668478]
         * Done in 1017 msecs
         */
    }

    /**
     * 使用CompletableFuture发起异步请求
     */
    public List<String> findPrices2(String product) {
        List<CompletableFuture<String>> priceFuture = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product), executor))
                .collect(Collectors.toList());
        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    /**
     * 构造同步和异步操作，见java8实战
     */
}
