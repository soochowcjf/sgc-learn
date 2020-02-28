package com.jvm.jvm3gc;

/**
 * @author:chenjinfeng
 * @date: 2018/7/4
 * @time: 23:14
 * @desc 栈上分配和内存逃逸分析
 * 逃逸分析主要作用：分析出对象的作用域，如果一个对象的作用域只在方法体内部中，就没有发生逃逸，就会栈上分配
 * 反之， 其他的就会发生逃逸。
 */
public class TestStackAllocation {

    public TestStackAllocation obj;

    /**
     * 发生逃逸
     */
    public TestStackAllocation getInstance() {
        return obj == null ? new TestStackAllocation() : obj;
    }

    /**
     * 为成员属性赋值
     * 发生逃逸
     */
    public void setObj() {
        this.obj = new TestStackAllocation();
    }

    /**
     * 对象的作用域仅在当前方法中有效，没有发生逃逸
     */
    public void use1() {
        TestStackAllocation t = new TestStackAllocation();
    }

    /**
     * 引用成员变量的值，发生逃逸
     */
    public void use2() {
        TestStackAllocation t2 = getInstance();
    }
}
