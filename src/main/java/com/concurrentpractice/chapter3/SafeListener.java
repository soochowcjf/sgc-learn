package com.concurrentpractice.chapter3;

/**
 * created by cjf 15:35 2019/1/27
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            //同样也会泄露 this 引用吧 ？？？
            @Override
            public void onEvent(Event e) {
                doSomething(e);
            }
        };
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
