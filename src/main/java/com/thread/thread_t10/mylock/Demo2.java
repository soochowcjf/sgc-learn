package com.thread.thread_t10.mylock;

/**
 * author:chenjinfeng
 * Date:2018/5/19
 * Time:23:37
 */
public class Demo2 {//测试pull代码 解决冲突

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("aaa");
        }//测试push   产生冲突
    }
}
