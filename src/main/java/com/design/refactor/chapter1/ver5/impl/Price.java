package com.design.refactor.chapter1.ver5.impl;

import com.design.refactor.chapter1.ver5.Movie;

/**
 * 状态模式
 *
 * @author cjf on 2020/4/9 18:34
 */
public abstract class Price {

    protected Movie movie;

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public abstract double getCharge(int daysRented);

    public abstract int getPriceCode();

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
