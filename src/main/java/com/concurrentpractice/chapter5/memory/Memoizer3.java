package com.concurrentpractice.chapter5.memory;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 相比Memoizer2，Memoizer3仍有一点小缺陷，仍会有小概率同一时间内调用compute()计算相同的值
 *
 * @author cjf on 2020/3/30 16:07
 */
public class Memoizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    //装饰者模式
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = () -> c.compute(arg);
            FutureTask<V> ft = new FutureTask<>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
