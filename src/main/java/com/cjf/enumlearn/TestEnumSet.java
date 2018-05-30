package com.cjf.enumlearn;

import org.junit.Test;

import java.util.EnumSet;

/**
 * @author:chenjinfeng
 * @Date:2018/5/30
 * @Time:23:21
 * 学习EnumSet
 */
public class TestEnumSet {

    /**
     * of方法有好几个重载的方法，它的作用是创建一个最初包含指定元素的枚举 set。
     */
    @Test
    public void fun() {
        EnumSet<EnumTest01> enumSet = EnumSet.of(EnumTest01.DELETE,EnumTest01.QUERY);
        for (EnumTest01 enumTest01 : enumSet) {
            System.out.println(enumTest01);
        }
    }

    /**
     * 创建一个包含指定元素类型的所有元素的枚举 set。
     */
    @Test
    public void fun2() {
        EnumSet<EnumTest01> enumSet = EnumSet.allOf(EnumTest01.class);
        for (EnumTest01 enumTest01 : enumSet) {
            System.out.println(enumTest01);
        }
    }

    /**
     *range方法    创建一个指定范围的Set。
     *noneOf方法   创建一个指定枚举类型的空set。
     *copyOf      创建一个set的并copy所传入的集合中的枚举元素。
     */
}
