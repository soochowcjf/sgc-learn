package com.concurrentpractice.chapter4;

import javax.annotation.concurrent.ThreadSafe;

/**
 * 使用java监视器模式的线程安全计数器
 *
 * @author cjf on 2020/3/27 16:55
 */
@ThreadSafe
public final class Counter {

    private long value = 0L;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalArgumentException("counter overflow");
        }
        return ++value;
    }
}
