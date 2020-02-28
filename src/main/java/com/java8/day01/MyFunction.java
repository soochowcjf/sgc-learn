package com.java8.day01;

/**
 * @author:chenjinfeng
 * @Date:2018/6/4
 * @Time:22:26
 * @desc
 */
@FunctionalInterface
public interface MyFunction<T> {

    public T getValue(T t);

}
