package com.design.refactor.chapter1.ver1;

public class Rental {
    /**
     * 影片
     */
    private Movie movie;
    /**
     * 租期
     */
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}