package com.cjf.annotation.proxy.sta;

import com.cjf.annotation.proxy.Flyable;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

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

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        Object o = map.putIfAbsent("123", 123);
        System.out.println(o);
        Object o1 = map.putIfAbsent("123", 456);
        System.out.println(o1);
    }
}
