package com.design.patterns.chapter18.model;

/**
 * @author cjf on 2019/12/6 16:55
 */
public class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void doAnything() {
        this.strategy.doSomething();
    }
}
