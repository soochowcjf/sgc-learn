package com.design.refactor.chapter1.ver5.impl;

import com.design.refactor.chapter1.ver5.Movie;
import com.design.refactor.chapter1.ver5.Price;

/**
 * 普通片
 *
 * @author cjf on 2020/4/9 18:45
 */
public class RegularPrice implements Price {
    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }

        return result;
    }

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
