package com.design.patterns.chapter12.dynamicproxy.model;

/**
 * @author cjf on 2019/12/4 11:00
 */
public class BeforeAdvice implements IAdvice {

    @Override
    public void exec() {
        System.out.println("前置通知被执行了。。。");
    }
}
