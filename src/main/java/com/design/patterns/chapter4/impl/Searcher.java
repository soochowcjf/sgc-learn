package com.design.patterns.chapter4.impl;

import com.design.patterns.chapter4.AbstractSearcher;
import com.design.patterns.chapter4.IPrettyGirl;

/**
 * @author cjf on 2019/12/1 22:09
 */
public class Searcher extends AbstractSearcher {

    @Override
    public void show(IPrettyGirl prettyGirl) {
        prettyGirl.goodLooking();
        prettyGirl.niceFutue();
        prettyGirl.greatTemperament();
    }
}
