package com.jvm.jvm2neicun;

import org.junit.Test;

/**
 * author:chenjinfeng
 * date: 2018/6/26
 * time: 22:40
 * desc  测试运行时常量池
 */
public class TestString {
    public static final String CHENJINFENG1 = "CHENJINFENG";
    public static final String CHENJINFENG2 = "CHENJINFENG";
    public static final String CHENJINFENG3 = new String("CHENJINFENG");

    @Test
    public void fun() {
        System.out.println(CHENJINFENG1 == CHENJINFENG2);

        System.out.println(CHENJINFENG1 == CHENJINFENG3);

        System.out.println(CHENJINFENG1 == CHENJINFENG3.intern());

        /**
         * true
         * false
         * true
         */
    }
}
