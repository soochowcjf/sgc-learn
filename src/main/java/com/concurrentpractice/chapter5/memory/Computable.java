package com.concurrentpractice.chapter5.memory;

import java.math.BigInteger;

/**
 * 计算接口
 *
 * @author cjf on 2020/3/30 15:48
 */
public interface Computable<A, V> {
    /**
     * 计算
     *
     * @param arg
     * @return
     * @throws InterruptedException
     */
    V compute(A arg) throws InterruptedException;

    class ExpensiveFunction implements Computable<String, BigInteger> {

        @Override
        public BigInteger compute(String arg) throws InterruptedException {
            //在经过长时间的计算后

            return new BigInteger(arg);
        }
    }
}
