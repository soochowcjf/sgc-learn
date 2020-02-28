package com.java8.day01.exec;

/**
 * @author:chenjinfeng
 * @Date:2018/6/4
 * @Time:23:59
 * @desc
 */
@FunctionalInterface
public interface MyFunction2<T, R> {
    public R operate(T t1, T t2);
}
