package com.design.patterns.chapter18.model;

/**
 * @author cjf on 2019/12/6 16:54
 */
public class ConcreteStrategy1 implements IStrategy {
    @Override
    public void doSomething() {
        System.out.println("ConcreteStrategy1");
    }
}
