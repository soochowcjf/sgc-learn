package com.concurrentpractice.chapter5.memory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 为了避免 {@link Memoizer1#compute} 加锁引起的并发性降低性能问题，这里优化使用ConcurrentHashMap来提高并发性
 * 但是也会导致一个问题，可能会导致重复计算
 *
 * @author cjf on 2020/3/30 16:01
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<>();
    //装饰者模式
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            V compute = c.compute(arg);
            cache.put(arg, compute);
        }
        return result;
    }
}
