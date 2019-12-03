package com.cjf.annotation.proxy.dynamic;

import com.cjf.annotation.proxy.Bird;
import com.cjf.annotation.proxy.Flyable;

/**
 * @author cjf on 2019/10/19 16:39
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Object obj = Proxy.newProxyInstance(Flyable.class, new MyInvocationHandler(new Bird()));
        System.out.println(obj.getClass().getName());
        ((Flyable)obj).fly();
    }
}
