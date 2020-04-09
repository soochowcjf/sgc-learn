package com.design.refactor.chapter1.ver5.impl;

import com.design.refactor.chapter1.ver5.Movie;
import com.design.refactor.chapter1.ver5.Price;

/**
 * 新片
 *
 * @author cjf on 2020/4/9 18:47
 */
public class NewReleasePrice implements Price {

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
