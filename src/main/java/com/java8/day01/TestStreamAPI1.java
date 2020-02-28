package com.java8.day01;

/**
 * @author:chenjinfeng
 * @date: 2018/8/12
 * @time: 20:55
 * @desc
 */

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 一、Stream API 的操作步骤：
 * <p>
 * 1. 创建 Stream
 * <p>
 * 2. 中间操作
 * <p>
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI1 {

    /**
     * 筛选与切片
     * filter——接收 Lambda ， 从流中排除某些元素。
     * limit——截断流，使其元素不超过给定数量。
     * skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
     * distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     */
    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.BUSY),
            new Employee("李四", 59, 6666.66, Employee.Status.FREE),
            new Employee("王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee("赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee("田七", 38, 5555.55, Employee.Status.BUSY),
            new Employee("田七", 38, 5555.55, Employee.Status.FREE),
            new Employee("田七", 38, 5555.55, Employee.Status.FREE)
    );

    //2.中间操作

    //1.创建stream
    @Test
    public void fun1() {
        //1. Collection 提供了两个方法  stream() 与 parallelStream()
        List<String> list = new ArrayList<>();
        //获取一个顺序流
        Stream<String> stream = list.stream();
        //获取一个并行流
        Stream<String> stringStream = list.parallelStream();

        //2.通过Arrays中的stream()获取一个数组流
        int[] arr = {1, 2, 3, 4};
        IntStream stream1 = Arrays.stream(arr);

        //3.通过 Stream 类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        //4.创建无限流
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
        stream3.forEach(System.out::println);

        //生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);
    }

    @Test
    public void fun2() {
        emps.stream().filter(x -> {
            System.out.println("filtering" + x.getName());
            return x.getSalary() > 6000;
        })
                .limit(2)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------");

        emps.stream().filter(e -> e.getSalary() > 5000)
                .distinct()
                .skip(2)
                .forEach(System.out::println);
    }

    /**
     * 映射
     * map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void fun3() {
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void fun4() {
        List<String> words = Arrays.asList("Hello", "World");
        words.stream()
                .flatMap(x -> Arrays.stream(x.split("")))
                .distinct()
                .forEach(System.out::println);

        System.out.println("--------------------------------------");

        words.stream()
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

        words.stream()
                .map(x -> x.split(""))
                .forEach(System.out::println);
        /**
         * H
         * e
         * l
         * o
         * W
         * r
         * d
         * --------------------------------------
         * H
         * e
         * l
         * l
         * o
         * W
         * o
         * r
         * l
         * d
         * [Ljava.lang.String;@122cdd0
         * [Ljava.lang.String;@81f4dc
         */
    }

    /**
     * sorted()——自然排序
     * sorted(Comparator com)——定制排序
     */
    @Test
    public void test2() {
        emps.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        emps.stream()
                .sorted((x, y) -> {
                    if (x.getAge() == y.getAge()) {
                        return x.getName().compareTo(y.getName());
                    } else {
                        return Integer.compare(x.getAge(), y.getAge());
                    }
                }).forEach(System.out::println);
    }

    //3. 终止操作

    /**
     * allMatch——检查是否匹配所有元素
     * anyMatch——检查是否至少匹配一个元素
     * noneMatch——检查是否没有匹配的元素
     * findFirst——返回第一个元素
     * findAny——返回当前流中的任意元素
     * count——返回流中元素的总个数
     * max——返回流中最大值
     * min——返回流中最小值
     */
    @Test
    public void fun5() {
        boolean b = emps.stream()
                .allMatch(e -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(b);

        boolean b1 = emps.stream()
                .anyMatch(e -> e.getName().equals("张三"));
        System.out.println(b1);

        boolean b2 = emps.stream()
                .noneMatch(e -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(b2);

        Optional<Employee> optional = emps.stream()
                .filter(e -> e.getSalary() > 5000)
                .findFirst();
        System.out.println(optional.get());

        Optional<Employee> any = emps.parallelStream()
                .filter(e -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(any);

        long count = emps.stream()
                .filter(e -> e.getStatus().equals(Employee.Status.FREE))
                .count();
        System.out.println(count);

        Optional<Employee> min = emps.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(min.get());

        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .max(Double::compareTo);
        System.out.println(max);
        /**
         * false
         * true
         * false
         * Employee{name='张三', age=18, salary=9999.99}
         * Optional[Employee{name='赵六', age=8, salary=7777.77}]
         * 4
         * Employee{name='王五', age=28, salary=3333.33}
         * Optional[9999.99]
         */
    }
}
