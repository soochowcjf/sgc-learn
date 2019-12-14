package com.design.patterns.chapter29;

/**
 * @author cjf on 2019/12/14 17:14
 */
public class HouseCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("盖房子。。。");
    }

    @Override
    protected void sell() {
        System.out.println("卖房子赚钱。。。");
    }
}
