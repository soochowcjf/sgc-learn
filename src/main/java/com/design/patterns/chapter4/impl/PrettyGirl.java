package com.design.patterns.chapter4.impl;

import com.design.patterns.chapter4.IPrettyGirl;

/**
 * @author cjf on 2019/12/1 22:08
 */
public class PrettyGirl implements IPrettyGirl {
    @Override
    public void goodLooking() {
        System.out.println("外形很好。。。");
    }

    @Override
    public void niceFutue() {
        System.out.println("身材很好。。。");

    }

    @Override
    public void greatTemperament() {
        System.out.println("气质很好。。。");
    }
}
