package com.design.patterns.chapter18.calculator;

/**
 * 策略枚举
 *
 * @author cjf on 2019/12/6 17:03
 */
public enum CalculatorEnum {

    /**
     * 加法
     */
    ADD("+") {
        @Override
        public int exec(int a, int b) {
            return a + b;
        }
    },

    /**
     * 减法
     */
    SUB("-") {
        @Override
        public int exec(int a, int b) {
            return a - b;
        }
    };
    private String value;

    CalculatorEnum(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int exec = CalculatorEnum.SUB.exec(a, b);
        System.out.println(exec);
    }

    public String getValue() {
        return this.value;
    }

    public abstract int exec(int a, int b);
}
