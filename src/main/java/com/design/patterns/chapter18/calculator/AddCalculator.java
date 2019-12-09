package com.design.patterns.chapter18.calculator;

/**
 * @author cjf on 2019/12/6 16:57
 */
public class AddCalculator implements Calculator {
    @Override
    public int exec(int a, int b) {
        return a + b;
    }
}
