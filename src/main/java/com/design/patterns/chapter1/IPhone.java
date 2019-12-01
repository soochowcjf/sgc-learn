package com.design.patterns.chapter1;

/**
 * 该接口负责两件事情
 * 1.协议管理
 * 2.数据传输
 * 不符合单一职责原则
 *
 * @author cjf on 2019/12/1 20:30
 */
public interface IPhone {

    /**
     * 拨通电话
     *
     * @param phoneNumber
     */
    void dial(String phoneNumber);

    /**
     * 通话
     *
     * @param o
     */
    void chat(Object o);

    /**
     * 挂断
     */
    void hangup();

}
