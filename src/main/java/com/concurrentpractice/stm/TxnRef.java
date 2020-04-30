package com.concurrentpractice.stm;

/**
 * 支持事务的引用
 */
public class TxnRef<E> {
    /**
     * 当前数据，带版本号
     * 代表的是系统中的最新值。
     */
    volatile VersionedRef curRef;

    public TxnRef(E value) {
        this.curRef = new VersionedRef(value, 0L);
    }

    /**
     * 获取当前事务中的数据
     */
    public E getValue(Txn txn) {
        return txn.get(this);
    }

    /**
     * 在当前事务中设置数据
     */
    public void setValue(E value, Txn txn) {
        txn.set(this, value);
    }
}