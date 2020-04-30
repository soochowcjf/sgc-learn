package com.concurrentpractice.stm;

@FunctionalInterface
public interface TxnRunnable {

    void run(Txn txn);
}