package com.design.patterns.chapter3;

/**
 * 2.setter方法传递
 *
 * @author cjf on 2019/12/1 21:37
 */
public class Driver2 implements IDriver {

    private ICar car;

    public void setCar(ICar car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.run();
    }
}
