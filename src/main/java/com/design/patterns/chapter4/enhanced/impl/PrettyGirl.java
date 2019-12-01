package com.design.patterns.chapter4.enhanced.impl;

import com.design.patterns.chapter4.enhanced.IGoodbodyGirl;
import com.design.patterns.chapter4.enhanced.IGreatTemperamentGirl;

/**
 * @author cjf on 2019/12/1 22:15
 */
public class PrettyGirl implements IGoodbodyGirl, IGreatTemperamentGirl {

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
