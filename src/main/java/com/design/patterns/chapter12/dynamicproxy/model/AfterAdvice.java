package com.design.patterns.chapter12.dynamicproxy.model;

/**
 * @author cjf on 2019/12/4 11:01
 */
public class AfterAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("后置通知被执行了。。。");
    }
}
