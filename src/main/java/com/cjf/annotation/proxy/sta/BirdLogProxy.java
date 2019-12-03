package com.cjf.annotation.proxy.sta;

import com.cjf.annotation.proxy.Flyable;

/**
 * @author cjf on 2019/10/19 15:34
 */
public class BirdLogProxy implements Flyable {

    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");
        flyable.fly();
        System.out.println("Bird fly end...");
    }
}
