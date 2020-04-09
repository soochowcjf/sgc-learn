package com.design.refactor.chapter1.ver5.impl;

import com.design.refactor.chapter1.ver5.Movie;

/**
 * 儿童
 *
 * @author cjf on 2020/4/9 18:42
 */
public class ChildrensPrice extends Price {

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
