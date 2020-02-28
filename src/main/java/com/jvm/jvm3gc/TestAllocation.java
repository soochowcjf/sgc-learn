package com.jvm.jvm3gc;

import org.junit.Test;

/**
 * @author:chenjinfeng
 * @date: 2018/7/3
 * @time: 22:56
 * @desc jvm内存分配的学习
 * 需要配置参数： -XX:+PrintGCDetails -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    /**
     * 对象优先在Eden分配
     * -XX:+PrintGCDetails -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     */
    @Test
    public void testAllocation() {

        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
//        System.gc();
    }

    /**
     * 大对象直接进入老年代
     * -XX:+PrintGCDetails -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=6M
     * -XX:PretenureSizeThreshold=6M    指定大于这个设置值的对象直接在老年代分配
     */
    @Test
    public void testPretenureSizeThreshold() {
        byte[] allocation;
        //对象直接分配到老年代中去
        allocation = new byte[7 * _1MB];
    }
}
