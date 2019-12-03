package com.cjf.annotation.proxy.dynamic;

import com.cjf.annotation.proxy.Bird;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author cjf on 2019/10/19 16:37
 */
public class MyInvocationHandler implements InvocationHandler {
    private Bird bird;

    public MyInvocationHandler(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void invoke(Object proxy, Method method, Object[] args) {
        long start = System.currentTimeMillis();

        try {
            method.invoke(bird, new Object[]{});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
