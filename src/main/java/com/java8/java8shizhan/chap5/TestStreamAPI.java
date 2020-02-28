package com.java8.java8shizhan.chap5;

import org.junit.Test;

import java.util.*;

/**
 * @author:chenjinfeng
 * @date: 2018/8/15
 * @time: 21:18
 * @desc
 */
public class TestStreamAPI {


    public static List<Transaction> transactions = Arrays.asList(new Transaction(Currency.EUR, 1500.0)
//            new Transaction(Currency.USD, 2300.0),
//            new Transaction(Currency.GBP, 9900.0),
//            new Transaction(Currency.EUR, 1100.0),
//            new Transaction(Currency.JPY, 7800.0),
//            new Transaction(Currency.CHF, 6700.0),
//            new Transaction(Currency.EUR, 5600.0),
//            new Transaction(Currency.USD, 4500.0),
//            new Transaction(Currency.CHF, 3400.0),
//            new Transaction(Currency.GBP, 3200.0),
//            new Transaction(Currency.USD, 4600.0),
//            new Transaction(Currency.JPY, 5700.0),
//            new Transaction(Currency.EUR, 6800.0)
    );

    @Test
    public void groupImperatively() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }

        System.out.println(transactionsByCurrencies);
    }

    public enum Currency {
        EUR, USD, JPY, GBP, CHF
    }

    public static class Transaction {
        private final Currency currency;
        private final double value;

        public Transaction(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return currency;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }
}
