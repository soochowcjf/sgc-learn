package com.concurrentpractice.chapter2;

/**
 * @author cjf on 2020/3/25 18:54
 */
public class Widget {

    public synchronized void doSomething() {
        System.out.println(this.getClass());

        System.out.println("Widget doSomething()...");
    }
}
