package com.concurrentpractice.stm;

/**
 * 事务接⼝
 */
public interface Txn {

    <T> T get(TxnRef<T> ref);

    <T> void set(TxnRef<T> ref, T value);
}
