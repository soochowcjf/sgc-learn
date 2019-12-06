package com.design.patterns.chapter18;

/**
 * @author cjf on 2019/12/6 16:35
 */
public class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        this.strategy.operate();
    }

}
