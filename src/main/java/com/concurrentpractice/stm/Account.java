package com.concurrentpractice.stm;

class Account {
    /**
     * 余额
     */
    private TxnRef<Integer> balance;

    public Account(int balance) {
        this.balance = new TxnRef<Integer>(balance);
    }

    /**
     * 转账操作
     */
    public void transfer(Account target, int amt) {
        STM.atomic((txn) -> {
            Integer from = balance.getValue(txn);
            balance.setValue(from - amt, txn);
            Integer to = target.balance.getValue(txn);
            target.balance.setValue(to + amt, txn);
        });
    }

    public static void main(String[] args) {
        Account from = new Account(10000);
        Account to = new Account(5000);
        from.transfer(to, 1000);


    }
}