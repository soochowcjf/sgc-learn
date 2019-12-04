package com.design.patterns.chapter12.dynamicproxy.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cjf on 2019/12/4 11:02
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 被代理类
     */
    private Subject target;

    public MyInvocationHandler(Subject subject) {
        this.target = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //被代理类执行的返回值

        return method.invoke(this.target, args);
    }
}
