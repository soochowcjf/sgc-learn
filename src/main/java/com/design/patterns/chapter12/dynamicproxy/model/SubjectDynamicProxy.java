package com.design.patterns.chapter12.dynamicproxy.model;

/**
 * 具体业务的动态代理，进一步封装
 *
 * @author cjf on 2019/12/4 14:14
 */
public class SubjectDynamicProxy extends DynamicProxy {

    public static <T> T newProxyInstance(Subject subject) {
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        return newProxyInstance(classLoader, interfaces, new MyInvocationHandler(subject));
    }
}
