package com.cjf.annotation.proxy.dynamic;

import java.lang.reflect.Method;

/**
 * @author cjf on 2019/10/19 16:38
 */
public interface InvocationHandler {
    void invoke(Object proxy, Method method, Object[] args);
}
