package com.design.patterns.chapter3;

/**
 * 依赖的三种方法
 * 1.构造函数传递
 *
 * @author cjf on 2019/12/1 21:35
 */
public class Driver1 implements IDriver {

    private ICar car;

    public Driver1(ICar car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.run();
    }
}
