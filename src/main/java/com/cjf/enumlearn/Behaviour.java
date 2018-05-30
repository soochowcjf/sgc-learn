package com.cjf.enumlearn;

/**
 * @author:chenjinfeng
 * @Date:2018/5/30
 * @Time:22:09
 * 用法五：实现接口
 * 所有的枚举都继承了Enum类，所有枚举对象不能再继承其他的类
 */
public interface Behaviour {
    void print();
    String getInfo();
}
