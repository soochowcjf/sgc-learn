package com.design.patterns.chapter1.srp;

/**
 * @author cjf on 2019/12/1 20:39
 */
public interface IConnectionManager {

    /**
     * 拨通电话
     *
     * @param phoneNumber
     */
    void dial(String phoneNumber);

    /**
     * 挂断
     */
    void hangup();

}
