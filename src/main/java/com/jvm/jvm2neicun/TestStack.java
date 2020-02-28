package com.jvm.jvm2neicun;


/**
 * author:chenjinfeng
 * date: 2018/6/26
 * time: 21:52
 * desc  演示栈帧溢出异常 StackOverflowError
 */
public class TestStack {

    public static void main(String[] args) {
        new TestStack().test();
    }

    /**
     * 递归调用
     */
    public void test() {
        System.out.println("创建栈帧");
        test();
    }
    //Exception in thread "main" java.lang.StackOverflowError
}
