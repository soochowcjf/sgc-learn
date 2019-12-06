package com.design.patterns.chapter18.calculator;

/**
 * @author cjf on 2019/12/6 17:00
 */
public class Client {
    public static void main(String[] args) {
        int a = 6;
        int b = 3;
        AddCalculator addCalculator = new AddCalculator();
        Context context = new Context(addCalculator);
        System.out.println(context.operate(a, b));
    }
}
