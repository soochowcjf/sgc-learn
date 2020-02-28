package com.java8.day01;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author:chenjinfeng
 * @Date:2018/6/4
 * @Time:21:55
 * @desc Lambda的语法学习
 * java8中引入了一种新的操作符："->" 该箭头成为箭头操作符或者Lambda操作符
 * 箭头操作符将Lambda表达式分为两个部分，左侧和右侧。
 * 左侧是参数列表，右侧是所需执行的功能，即Lambda体
 * 语法格式一：无参数，无返回值
 * Runnable r2 = () -> System.out.println("Hello Lambda!");
 * 语法格式二：有一个参数，并且无返回值
 * Consumer con = (x) -> System.out.println(x);
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * Consumer con = x -> System.out.println(x);
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 * Comparator<Integer> comparator = (x, y) -> {
 * System.out.println("5555555555");
 * return Integer.compare(x, y);
 * };
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * Comparator<Integer> comparator = (x ,y) -> Integer.compare(x, y);
 * <p>
 * <p>
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 可以检查是否是函数式接口
 */
public class TestLambda2 {
    @Test
    public void fun1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        };
        r1.run();
        System.out.println("------------------------");
        Runnable r2 = () -> System.out.println("Hello Lambda!");
        r2.run();
    }

    @Test
    public void fun2() {
        Consumer con = (x) -> System.out.println(x);
        con.accept("33333333333");
    }

    @Test
    public void fun3() {
        Consumer con = x -> System.out.println(x);
        con.accept("4444444444");
    }

    @Test
    public void fun4() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("5555555555");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void fun5() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    /**
     * 需求：对一个数进行运算
     */
    @Test
    public void fun6() {
        int num = 100;
        Integer value = operate(num, (x) -> {
            return x * x;
        });
        System.out.println(value);
        System.out.println("-----------------");
        Integer value2 = operate(num, x -> x + 200);
        System.out.println(value2);
    }

    public Integer operate(Integer i, MyFunction<Integer> myFunction) {
        return myFunction.getValue(i);
    }
}
