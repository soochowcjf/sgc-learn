package com.design.patterns.chapter29;

/**
 * @author cjf on 2019/12/14 17:15
 */
public class ClothesCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("造衣服。。。");
    }

    @Override
    protected void sell() {
        System.out.println("卖衣服赚钱。。。");
    }
}
