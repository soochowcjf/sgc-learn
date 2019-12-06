package com.design.patterns.chapter18.calculator;

/**
 * @author cjf on 2019/12/6 16:35
 */
public class Context {

    private Calculator calculator;

    public Context(Calculator calculator) {
        this.calculator = calculator;
    }

    public int operate(int a, int b) {
        return this.calculator.exec(a, b);
    }

}
