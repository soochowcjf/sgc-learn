package com.cjf.hutool.number;

import java.math.BigDecimal;

/**
 * @author cjf on 2019/12/27 18:00
 */
public class Demo {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(0.1 + "");
        System.out.println(bigDecimal);
    }
}
