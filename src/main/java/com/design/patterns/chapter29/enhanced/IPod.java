package com.design.patterns.chapter29.enhanced;

/**
 * @author cjf on 2019/12/14 17:37
 */
public class IPod extends Product {
    @Override
    public void beProduced() {
        System.out.println("IPod被生产了。。。");
    }

    @Override
    public void beSold() {
        System.out.println("IPod被销售了。。。");
    }
}
