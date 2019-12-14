package com.design.patterns.chapter29;

/**
 * @author cjf on 2019/12/14 17:12
 */
public abstract class Corp {

    /**
     * 生产
     */
    protected abstract void produce();

    /**
     * 销售
     */
    protected abstract void sell();


    /**
     * 赚钱
     */
    public void makeMoney() {
        produce();
        sell();
    }
}
