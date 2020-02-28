package com.java8.day01;

/**
 * @author:chenjinfeng
 * @Date:2018/6/3
 * @Time:22:16 策略模式优化
 */
public interface MyPredicate<T> {

    public boolean filter(T t);
}
