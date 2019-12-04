package com.design.patterns.chapter12.dynamicproxy.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author cjf on 2019/12/4 14:03
 */
public class DynamicProxy {

    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler invocationHandler) {
        //寻找joinpoint连接点，apo框架使用元数据定义

        if (true) {
            //执行前置通知
            new BeforeAdvice().exec();
        }
        return (T) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
    }
}
