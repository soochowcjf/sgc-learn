package com.design.patterns.chapter12.dynamicproxy.model;

/**
 * @author cjf on 2019/12/4 10:58
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething(String str) {
        System.out.println("doSomething --------" + str);
    }

}
