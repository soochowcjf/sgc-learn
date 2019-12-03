package com.cjf.annotation.proxy;

import java.util.Random;

/**
 * @author cjf on 2019/10/19 15:29
 */
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
