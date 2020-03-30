package com.concurrentpractice.chapter5.memory;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 最终版本，使用 putIfAbsent() 原子性方法
 * 但仍会有缓存污染的问题，如果计算被取消或者失败
 *
 * @author cjf on 2020/3/30 16:07
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    //装饰者模式
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = () -> c.compute(arg);
            FutureTask<V> ft = new FutureTask<>(eval);
            f = cache.putIfAbsent(arg, ft);
            if (null == f) {
                f = ft;
                ft.run();
            }
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
