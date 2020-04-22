package com.concurrentpractice.chapter15;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author cjf on 2020/4/21 17:08
 */
public class Demo {

    private static final ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        queue.offer(1);
        queue.offer(2);

        for (int i = 0; i < 0; i++) {
            System.out.println(i);
        }

    }
}
