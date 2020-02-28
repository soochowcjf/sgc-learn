package com.jvm.testjconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * author:chenjinfeng
 * date: 2018/6/20
 * time: 23:25
 * desc  jconsole的使用
 */
public class TestJConsole {

    //成员变量 => 不会被gc回收，堆内存越来愈大
//    public byte[] b = new byte[1024*64];


    public TestJConsole() {
        //局部变量，可以被gc回收
        byte[] b = new byte[1024 * 64];
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
            System.out.println("start ......");
            fill(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void fill(int j) {
        List<TestJConsole> list = new ArrayList<TestJConsole>();
        for (int i = 0; i < j; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new TestJConsole());
        }
    }
}
