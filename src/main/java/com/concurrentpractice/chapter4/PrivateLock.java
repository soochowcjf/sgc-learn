package com.concurrentpractice.chapter4;

/**
 * 通过一个私有锁来保护状态
 *
 * @author cjf on 2020/3/27 17:07
 */
public class PrivateLock {
    private final Object myLock = new Object();

    void someMethod() {
        synchronized (myLock) {
            //访问或修改widget的状态
        }
    }
}
