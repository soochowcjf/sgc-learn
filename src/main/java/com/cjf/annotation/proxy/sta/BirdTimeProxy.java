package com.cjf.annotation.proxy.sta;

import com.cjf.annotation.proxy.Flyable;

import java.time.Duration;
import java.time.Instant;

/**
 * @author cjf on 2019/10/19 15:32
 */
public class BirdTimeProxy implements Flyable {

    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        Instant start = Instant.now();
        flyable.fly();
        Instant end = Instant.now();
        System.out.println("Fly time = " + Duration.between(start, end).toMillis());
    }
}
