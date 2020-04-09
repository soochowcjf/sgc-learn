package com.design.refactor.chapter1.ver5.impl;

/**
 * 状态模式
 *
 * @author cjf on 2020/4/9 18:34
 */
public interface Price {

    /**
     * @param daysRented
     * @return
     */
    double getCharge(int daysRented);

    /**
     * @return
     */
    int getPriceCode();

    default int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
