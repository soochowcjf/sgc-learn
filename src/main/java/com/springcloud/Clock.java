package com.springcloud;

/**
 * @author cjf on 2020/3/5 19:15
 */
@FunctionalInterface
public interface Clock {

    Clock WALL = System::currentTimeMillis;

    long now();

}
