package com.design.patterns.chapter26;

/**
 * @author cjf on 2020/4/9 20:37
 */
public interface ILift {

    /**
     * 敞门状态
     */
    int OPENING_STATE = 1;
    /**
     * 闭门状态
     */
    int CLOSING_STATE = 2;
    /**
     * 运行状态
     */
    int RUNNING_STATE = 3;
    /**
     * 停止状态
     */
    int STOPPING_STATE = 4;

    /**
     * 设置状态
     *
     * @param state
     */
    void setState(int state);

    /**
     * 开门
     */
    void open();

    /**
     * 关门
     */
    void close();

    /**
     * 运行
     */
    void run();

    /**
     * 停止
     */
    void stop();
}
