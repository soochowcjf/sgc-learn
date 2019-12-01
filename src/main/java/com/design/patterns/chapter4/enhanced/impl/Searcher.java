package com.design.patterns.chapter4.enhanced.impl;

import com.design.patterns.chapter4.enhanced.AbstractSearcher;
import com.design.patterns.chapter4.enhanced.IGreatTemperamentGirl;

/**
 * @author cjf on 2019/12/1 22:17
 */
public class Searcher extends AbstractSearcher {

    @Override
    public void show(IGreatTemperamentGirl greatTemperamentGirl) {
        greatTemperamentGirl.greatTemperament();
    }
}
