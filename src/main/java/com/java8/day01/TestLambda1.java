package com.java8.day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:chenjinfeng
 * @Date:2018/6/3
 * @Time:22:01
 */
public class TestLambda1 {

    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 59, 6666.66),
            new Employee("王五", 28, 3333.33),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 38, 5555.55)
    );

    /**
     * 原始方式：
     * 需求：获取公司中年龄大于 35 的员工信息
     * -->  添加需求：获取公司中工资大于 5000 的员工信息
     */
    @Test
    public void filterEmp1() {
        List<Employee> employees = filterEmpByAge(emps);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("---------------------------------------------");

        List<Employee> employees2 = filterEmpBySal(emps);
        for (Employee employee : employees2) {
            System.out.println(employee);
        }
    }

    /**
     * 根据年龄大于35过滤
     */
    public List<Employee> filterEmpByAge(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() > 35) {
                emps.add(employee);
            }
        }
        return emps;
    }

    /**
     * 获取工资大于5000的员工
     */
    public List<Employee> filterEmpBySal(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() > 5000) {
                emps.add(employee);
            }
        }
        return emps;
    }

    /**
     * 优化方式一：获取年龄大于35的员工信息
     * 策略模式，定义一个接口,具体接口分别实现
     */
    public List<Employee> filterEmp(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.filter(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }

    @Test
    public void filterEmp2() {
        List<Employee> employees = filterEmp(emps, new FilterEmpForAge());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方式二：匿名内部类实现MyPredicate接口
     * 获取工资大于5000的员工信息
     */
    @Test
    public void filterEmp3() {
        List<Employee> employees = filterEmp(emps, new MyPredicate<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getSalary() > 5000;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方式三：lambda表达式
     */
    @Test
    public void filterEmp4() {
        List<Employee> list = filterEmp(emps, (e) -> e.getAge() > 35);
        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println("--------------------------------------------");

        List<Employee> employees = filterEmp(emps, (emp) -> emp.getSalary() > 5000);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方式四：Stream API
     */
    @Test
    public void filterEmp5() {
        emps.stream()
                .filter((e) -> e.getAge() > 35)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");

        emps.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.out::println);
    }

}
