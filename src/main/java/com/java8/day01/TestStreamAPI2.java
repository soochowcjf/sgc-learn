package com.java8.day01;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:chenjinfeng
 * @date: 2018/8/14
 * @time: 23:14
 * @desc
 */
public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.BUSY),
            new Employee("李四", 59, 6666.66, Employee.Status.FREE),
            new Employee("王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee("赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee("田七", 38, 5555.55, Employee.Status.BUSY),
            new Employee("田七", 38, 5555.55, Employee.Status.FREE),
            new Employee("田七", 38, 5555.55, Employee.Status.FREE)
    );

    //3. 终止操作

    /**
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void fun1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(100, Integer::sum);
        System.out.println(sum);

        System.out.println("-------------------------------------------");

        Optional<Integer> optional = list.stream()
                .reduce((x, y) -> x * y);
        System.out.println(optional.get());
        /**
         * 155
         * -------------------------------------------
         * 3628800
         */
    }

    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void fun2() {
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        emps.stream()
                .map(Employee::getAge)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
    }

    //组函数
    @Test
    public void fun3() {
        Optional<Double> optional = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));
        System.out.println(optional.get());

        Optional<Employee> optional1 = emps.stream()
                .collect(Collectors.minBy((x, y) -> Integer.compare(x.getAge(), y.getAge())));
        System.out.println(optional1.get());

        Double aDouble = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(aDouble);

        Double collect = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect);

        Long collect1 = emps.stream()
                .collect(Collectors.counting());
        System.out.println(collect1);

        DoubleSummaryStatistics doubleSummaryStatistics = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(doubleSummaryStatistics);
        /**
         * 9999.99
         * Employee{name='赵六', age=8, salary=7777.77}
         * 44444.4
         * 6349.2
         * 7
         * DoubleSummaryStatistics{count=7, sum=44444.400000, min=3333.330000, average=6349.200000, max=9999.990000}
         */
    }

    //分组,可以嵌套多个分组条件
    @Test
    public void test5() {
        Map<Employee.Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
        /**
         * {VOCATION=[Employee{name='王五', age=28, salary=3333.33}], FREE=[Employee{name='李四', age=59, salary=6666.66},
         *  Employee{name='赵六', age=8, salary=7777.77}, Employee{name='田七', age=38, salary=5555.55},
         *  Employee{name='田七', age=38, salary=5555.55}],
         *  BUSY=[Employee{name='张三', age=18, salary=9999.99}, Employee{name='田七', age=38, salary=5555.55}]}
         */
    }

    //分区
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));
        System.out.println(map);
        /**
         * {false=[Employee{name='王五', age=28, salary=3333.33}],
         *  true=[Employee{name='张三', age=18, salary=9999.99},
         *  Employee{name='李四', age=59, salary=6666.66},
         *  Employee{name='赵六', age=8, salary=7777.77},
         *  Employee{name='田七', age=38, salary=5555.55},
         *  Employee{name='田七', age=38, salary=5555.55},
         *  Employee{name='田七', age=38, salary=5555.55}]}
         */
    }

    //字符串拼接

    @Test
    public void test8() {
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "----", "----"));

        System.out.println(str);
        /**
         * ----张三,李四,王五,赵六,田七,田七,田七----
         */
    }

    @Test
    public void test9() {
        Optional<Double> sum = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(Double::sum));

        System.out.println(sum.get());
        /**
         * 44444.40000000001
         */
    }
}
