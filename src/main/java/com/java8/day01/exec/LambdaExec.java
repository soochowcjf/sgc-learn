package com.java8.day01.exec;

import com.java8.day01.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @author:chenjinfeng
 * @Date:2018/6/4
 * @Time:23:42
 * @desc
 */
public class LambdaExec {
    List<Employee> list = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 59, 6666.66),
            new Employee("王五", 28, 3333.33),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 38, 5555.55)
    );

    /**
     * 需求一：先按年龄排，再按照姓名排序
     */
    @Test
    public void fun1() {
        Collections.sort(list, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                //按照姓名排序
                return x.getName().compareTo(y.getName());
            } else {
                //按照年龄排序
                return Integer.compare(x.getAge(), y.getAge());
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
        /**
         * Employee{name='赵六', age=8, salary=7777.77}
         * Employee{name='张三', age=18, salary=9999.99}
         * Employee{name='王五', age=28, salary=3333.33}
         * Employee{name='田七', age=38, salary=5555.55}
         * Employee{name='李四', age=59, salary=6666.66}
         */
    }

    @Test
    public void sort() {
        //静态导入
        list.sort(comparing(Employee::getAge).reversed());
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    /**
     * 需求二：类中编写方法使用接口作为参数，将一个字符串转换成大写
     */
    public String trans(String str, MyFunction myFunction) {
        return myFunction.getValue(str);
    }

    @Test
    public void fun2() {
        String str = "i love u liuyue";
        String uppcaseStr = trans(str, x -> x.toUpperCase());
        System.out.println(uppcaseStr);
        /**
         * I LOVE U LIUYUE
         */
    }

    /**
     * 需求三：声明带有两个泛型的接口，泛型类型为<T,R>,T为参数，R 为返回值
     * 接口中声明对应的抽象方法
     * 使用接口作为参数，计算两个long型参数的和，和两个long型参数的积
     */
    public void category(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.operate(l1, l2));
    }

    @Test
    public void fun3() {
        category(10L, 20L, (x, y) -> x + y);
        System.out.println("-----------------");
        category(10L, 20L, (x, y) -> x * y);
        /**
         * 30
         * -----------------
         * 200
         */
    }

}
