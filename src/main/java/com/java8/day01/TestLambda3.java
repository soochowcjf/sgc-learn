package com.java8.day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author:chenjinfeng
 * @Date:2018/6/5
 * @Time:22:50
 * @desc java8内置的四大核心函数式接口
 * <p>
 * Consumer<T> :消费型接口
 * void accept(T t)
 * <p>
 * Supplier<T> ：供给型接口
 * T get<T t>
 * <p>
 * Function<T,R> :函数式接口
 * R apply(T,t)
 * <p>
 * Predicate<T> :断言型接口
 * boolean test(T t)
 */
public class TestLambda3 {
    List<String> list = Arrays.asList("11111", "222222", "33333333", "444444444", "5555555555");

    /**
     * Consumer<T> :消费型接口
     */
    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void fun1() {
        happy(10000, x -> System.out.println("陈金烽买macbookpro花了" + x + "元"));
    }

    /**
     * Supplier<T> ：供给型接口
     * 需求：产生指定个数的整数，并放入集合中
     */
    public List<Integer> getNumList(int i, Supplier<Integer> supplier) {
        List<Integer> numList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Integer num = supplier.get();
            numList.add(num);
        }
        return numList;
    }

    @Test
    public void fun2() {
        List<Integer> numList = getNumList(8, () -> (int) (Math.random() * 100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    /**
     * Function<T,R> :函数式接口
     * 需求：处理字符串
     */
    public String strHandler(String str, Function<String, String> function) {
        String apply = function.apply(str);
        return apply;
    }

    @Test
    public void fun3() {
        String uppStr = strHandler("wo ai zhongguo", x -> x.toUpperCase());
        System.out.println(uppStr);
    }

    /**
     * Predicate<T> :断言型接口
     * 需求：将满足条件的字符串，放入集合中
     */
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> newList = new ArrayList<>();
        for (String string : list) {
            if (predicate.test(string)) {
                newList.add(string);
            }
        }
        return newList;
    }

    @Test
    public void fun4() {
        List<String> list2 = filterStr(list, x -> x.length() > 6);
        for (String s : list2) {
            System.out.println(s);
        }
    }


}
