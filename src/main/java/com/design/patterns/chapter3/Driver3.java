package com.design.patterns.chapter3;

/**
 * 3.接口声明依赖传递
 *
 * @author cjf on 2019/12/1 21:38
 */
public class Driver3 implements IDriver2 {

    @Override
    public void drive(ICar car) {
        car.run();
    }
}
