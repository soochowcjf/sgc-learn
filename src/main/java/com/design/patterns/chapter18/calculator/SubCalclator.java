package com.design.patterns.chapter18.calculator;

/**
 * @author cjf on 2019/12/6 16:58
 */
public class SubCalclator implements Calculator {
    @Override
    public int exec(int a, int b) {
        return a - b;
    }
}
