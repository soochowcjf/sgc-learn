package com.concurrentpractice.chapter5.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * 在compute方法直接加了synchronized，如果计算任务的时间较长的话，会导致多个线程的等待
 *
 * @author cjf on 2020/3/30 15:56
 */
public class Memoizer1<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<>();
    //装饰者模式
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            V compute = c.compute(arg);
            cache.put(arg, compute);
        }
        return result;
    }
}
