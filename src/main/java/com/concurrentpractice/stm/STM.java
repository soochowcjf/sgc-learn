package com.concurrentpractice.stm;

/**
 * Software	Transactional Memory，软件事务内存
 */
public final class STM {

    //提交数据需要⽤到的全局锁
    static final Object commitLock = new Object();

    private STM() {
    }

    //原⼦化提交⽅法
    public static void atomic(TxnRunnable action) {
        boolean committed = false;
        //如果没有提交成功，则⼀直重试
        while (!committed) {
            //创建新的事务
            STMTxn txn = new STMTxn();
            //执⾏业务逻辑
            action.run(txn);
            //提交事务
            committed = txn.commit();
        }
    }
}