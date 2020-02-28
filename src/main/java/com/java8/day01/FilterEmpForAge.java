package com.java8.day01;

/**
 * @author:chenjinfeng
 * @Date:2018/6/3
 * @Time:22:21 为年龄过滤的接口实现
 */
public class FilterEmpForAge implements MyPredicate<Employee> {

    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() > 35;
    }
}
