package com.concurrentpractice.chapter3;

/**
 * 发布与溢出
 * this引用溢出
 * created by cjf 11:23 2019/1/27
 */
public class ThisEscape {

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            //会存在对 ThisEscape 的隐含引用
            @Override
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
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
