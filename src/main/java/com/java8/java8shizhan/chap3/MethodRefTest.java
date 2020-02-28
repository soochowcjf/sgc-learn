package com.java8.java8shizhan.chap3;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author:chenjinfeng
 * @date: 2018/8/8
 * @time: 22:15
 * @desc
 */
public class MethodRefTest {
    public String mergeText(String text, Function<String, String> function) {
        return function.apply(text);
    }

    @Test
    public void fun() {
        Function<String, String> function = Letter::addHeader;
        Function<String, String> function1 = function.andThen(Letter::addFooter);

        String mergeText = mergeText("kanjie", function1);
        System.out.println(mergeText);
        /**
         * From chenjinfeng: kanjie Kind regards!
         */
    }
}
