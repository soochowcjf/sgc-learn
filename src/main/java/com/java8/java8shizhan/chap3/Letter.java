package com.java8.java8shizhan.chap3;

/**
 * @author:chenjinfeng
 * @date: 2018/8/8
 * @time: 22:11
 * @desc
 */
public class Letter {

    public static String addHeader(String text) {
        return "From chenjinfeng: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards!";
    }
}
