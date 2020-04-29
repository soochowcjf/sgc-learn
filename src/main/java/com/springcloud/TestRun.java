package com.springcloud;

/**
 * @author cjf on 2020/4/28 16:40
 */
public class TestRun implements Runnable {

    private static final ThreadLocal<String> NAME = ThreadLocal.withInitial(() -> Thread.currentThread().getName());

    @Override
    public void run() {
        try {
            System.out.println(NAME.get());
        } finally {
            NAME.remove();
        }
    }
}
