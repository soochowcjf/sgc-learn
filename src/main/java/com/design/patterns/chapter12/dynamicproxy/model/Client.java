package com.design.patterns.chapter12.dynamicproxy.model;

/**
 * @author cjf on 2019/12/4 11:13
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        Subject subjectProxy = (Subject) DynamicProxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), myInvocationHandler);
        subjectProxy.doSomething("测试");

    }
}
