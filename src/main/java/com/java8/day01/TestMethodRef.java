package com.java8.day01;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * @author:chenjinfeng
 * @Date:2018/6/6
 * @Time:22:16
 * @desc 方法引用、构造器引用、数组引用的学习
 * 一、方法引用：若Lambda体中的功能，已经有方法提供了实现，可以使用方法引用
 * （可以将方法引用理解为Lambda表达式的另外一种表现形式）
 * <p>
 * 1. 对象的引用 :: 实例方法名
 * <p>
 * 2. 类名 :: 静态方法名
 * <p>
 * 3. 类名 :: 实例方法名
 * <p>
 * 注意：
 * ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 * <p>
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * <p>
 * 1. 类名 :: new
 * <p>
 * 三、数组引用
 * <p>
 * 类型[] :: new;
 */
public class TestMethodRef {
    /**
     * 1. 对象的引用 :: 实例方法名
     */
    @Test
    public void fun1() {
        Consumer<String> consumer = x -> System.out.println(x);

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("chenjinfeng");
        //chenjinfeng
    }

    @Test
    public void fun2() {
        Employee employee = new Employee(10);
        Supplier<Integer> supplier = employee::getAge;
        Integer age = supplier.get();
        System.out.println(age);
        //10
    }

    /**
     * 2. 类名 :: 静态方法名
     */
    @Test
    public void fun3() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> comparator1 = Integer::compare;
        int compare = comparator1.compare(4, 5);
        System.out.println(compare);
        //-1
    }

    @Test
    public void fun4() {
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> Math.max(x, y);

        BiFunction<Integer, Integer, Integer> biFunction1 = Math::max;
        Integer apply = biFunction1.apply(4, 5);
        System.out.println(apply);
        //5
    }

    /**
     * 3. 类名 :: 实例方法名
     */
    @Test
    public void fun5() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPredicate1 = String::equals;
        boolean test = biPredicate.test("123", "123");
        System.out.println(test);
        //true
    }

    @Test
    public void fun6() {
        Employee employee = new Employee(24);
        Function<Employee, Integer> function = Employee::getAge;
        Integer apply = function.apply(employee);
        System.out.println(apply);
        //24
    }

    /**
     * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
     * 类名 :: new
     */
    @Test
    public void fun7() {
        Function<Integer, Employee> function = Employee::new;
        Employee apply = function.apply(25);
        System.out.println(apply);
        //Employee{name='null', age=25, salary=0.0}

        BiFunction<String, Integer, Employee> biFunction = Employee::new;
        Employee chenjinfeng = biFunction.apply("chenjinfeng", 18);
        System.out.println(chenjinfeng);
        //Employee{name='chenjinfeng', age=18, salary=0.0}
    }

    /**
     * 三、数组引用
     * 类型[] :: new;
     */
    @Test
    public void fun8() {
        Function<Integer, String[]> fun = (args) -> new String[args];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);
        //10

        Function<Integer, Employee[]> fun2 = Employee[]::new;
        Employee[] emps = fun2.apply(20);
        System.out.println(emps.length);
        //20
    }
}
