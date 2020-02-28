package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * author:chenjinfeng
 * date: 2018/6/20
 * time: 22:34
 * desc  演示内存溢出
 */
public class helloworld {
    public static void main(String[] args) {
        List<Demo> list = new ArrayList<Demo>();
        while (true) {
            list.add(new Demo());
        }
    }

    static class Demo {

    }
}
