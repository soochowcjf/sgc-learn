package com.concurrentpractice.chapter2;

/**
 * @author cjf on 2020/3/25 18:54
 */
public class LoggingWidget extends Widget {
    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }

    @Override
    public synchronized void doSomething() {
        System.out.println(this.getClass());
        System.out.println("LoggingWidget doSomething()...");
        super.doSomething();
    }
}
