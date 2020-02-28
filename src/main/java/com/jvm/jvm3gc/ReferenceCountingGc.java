package com.jvm.jvm3gc;

/**
 * author:chenjinfeng
 * date: 2018/6/27
 * time: 23:13
 * desc  引用计数算法的演示
 * 需要在idea中配置参数 ：  -XX:+PrintGCDetails
 */
public class ReferenceCountingGc {

    private Object instance;

    /**
     * 2兆的内存大小,目的在gc日志中可以看清楚是否被回收过
     */
    private byte[] bigsize = new byte[1024 * 1024 * 2];

    public static void main(String[] args) {
        ReferenceCountingGc r1 = new ReferenceCountingGc();
        ReferenceCountingGc r2 = new ReferenceCountingGc();

        r1.instance = r2;
        r2.instance = r1;

        r1 = null;
        r2 = null;

        System.gc();


    }
}
