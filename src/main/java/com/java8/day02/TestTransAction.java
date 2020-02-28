package com.java8.day02;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:chenjinfeng
 * @date: 2018/8/16
 * @time: 22:24
 * @desc
 */
public class TestTransAction {

    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
    @Test
    public void fun1() {
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
        /**
         * Transaction [trader=Trader [name=Brian, city=Cambridge], year=2011, value=300]
         * Transaction [trader=Trader [name=Raoul, city=Cambridge], year=2011, value=400]
         */
    }

    //2. 交易员都在哪些不同的城市工作过？
    @Test
    public void fun2() {
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        /**
         * Cambridge
         * Milan
         */
    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void fun3() {
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);
        /**
         * Trader [name=Alan, city=Cambridge]
         * Trader [name=Brian, city=Cambridge]
         * Trader [name=Raoul, city=Cambridge]
         */
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void fun4() {
        String collect = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(collect);
        /**
         * Alan,Brian,Mario,Mario,Raoul,Raoul
         */
    }

    //5. 有没有交易员是在米兰工作的？
    @Test
    public void fun5() {
        boolean b = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(b);
        /**
         * true
         */
    }

    //6. 打印生活在剑桥的交易员的所有交易额
    @Test
    public void fun6() {
        int sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Milan"))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println(sum);
        /**
         * 1410
         */
    }

    //7. 所有交易中，最高的交易额是多少
    @Test
    public void fun7() {
        OptionalInt max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();
        System.out.println(max.getAsInt());
        /**
         * 1000
         */
    }

    //8. 找到交易额最小的交易
    @Test
    public void fun8() {
        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
        System.out.println(min.get());
        /**
         * Transaction [trader=Trader [name=Brian, city=Cambridge], year=2011, value=300]
         */
    }
}
