package com.cjf.guava.cache;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjinfeng
 * @create 17:42 2018/12/7
 * @desc 学习guava cache的使用
 **/
public class TestGuavaCache {

    @Test
    public void fun1() {
        Cache<Object, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(30, TimeUnit.SECONDS)
                .build();
        cache.put("word", "Hello Guava Cache");
        System.out.println(cache.getIfPresent("word"));

    }

    @Test
    public void fun2() {
        Cache<Object, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));
        System.out.println("第三个值：" + cache.getIfPresent("key3"));
    }

    @Test
    public void fun3() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1", "value1");
        int time = 1;
        while (true) {
            System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
    }

    @Test
    public void fun4() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterAccess(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1", "value1");
        int time = 1;
        while (true) {
            Thread.sleep(time * 1000);
            System.out.println("睡眠" + time++ + "秒后取到key1的值为：" + cache.getIfPresent("key1"));
        }
    }

    @Test
    public void fun5() {
        Cache<String, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .weakValues()
                .build();
        Object value = new Object();
        cache.put("key1", value);

        //原对象不再有强引用
        value = new Object();
        System.gc();
        System.out.println(cache.getIfPresent("key1"));
    }

    @Test
    public void fun6() {
        //缓存清除监听
        RemovalListener<String, String> listener = new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> notification) {
                System.out.println("[" + notification.getKey() + ":" + notification.getValue() + "] is removed!");
            }
        };

        Cache<String,String> cache = CacheBuilder.newBuilder().removalListener(listener).build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");

        //清空缓存
//        cache.invalidateAll();

        List<String> list = new ArrayList<>();
        list.add("key1");
        list.add("key2");

        //批量清除list中全部key对应的记录
        cache.invalidateAll(list);
        System.out.println(cache.getIfPresent("key1"));
        System.out.println(cache.getIfPresent("key2"));
        System.out.println(cache.getIfPresent("key3"));

        /**
         * [key1:value1] is removed!
         * [key2:value2] is removed!
         * null
         * null
         * value3
         */
    }

    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build();

        new Thread(() -> {
            System.out.println("thread1");
            try {
                String value = cache.get("key", new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        //加载数据线程执行标志
                        System.out.println("load1");
                        //模拟加载时间
                        Thread.sleep(1000);
                        return "auto load by Callable";
                    }
                });
                System.out.println("thread1 " + value);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("thread2");
            try {
                String value = cache.get("key", new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        //加载数据线程执行标志
                        System.out.println("load2");
                        //模拟加载时间
                        Thread.sleep(1000);
                        return "auto load by Callable";
                    }
                });
                System.out.println("thread2 " + value);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        /**
         * thread1
         * thread2
         * load2
         * thread1 auto load by Callable
         * thread2 auto load by Callable
         */
    }

    @Test
    public void fun7() throws ExecutionException {
        CacheLoader<String, String> loader = new CacheLoader<String, String> () {
            @Override
            public String load(String key) throws Exception {
                //休眠1s，模拟加载数据
                Thread.sleep(1000);
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                //在构建时指定自动加载器
                .build(loader);

        loadingCache.get("key1");
        loadingCache.get("key2");
        loadingCache.get("key3");

        /**
         * key1 is loaded from a cacheLoader!
         * key2 is loaded from a cacheLoader!
         * key3 is loaded from a cacheLoader!
         */
    }

}
