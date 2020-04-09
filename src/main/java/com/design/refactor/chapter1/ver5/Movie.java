package com.design.refactor.chapter1.ver5;

import com.design.refactor.chapter1.ver5.impl.ChildrensPrice;
import com.design.refactor.chapter1.ver5.impl.NewReleasePrice;
import com.design.refactor.chapter1.ver5.impl.Price;
import com.design.refactor.chapter1.ver5.impl.RegularPrice;

/**
 * 状态模式进行优化
 */
public class Movie {
    /**
     * 儿童
     */
    public static final int CHILDRENS = 2;
    /**
     * 普通片
     */
    public static final int REGULAR = 0;
    /**
     * 新片
     */
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
        this.price.setMovie(this);
    }

    public int getPriceCode() {
        return this.price.getPriceCode();
    }

    /**
     * 设定价格代号
     */
    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                this.price = new RegularPrice();
                break;
            case CHILDRENS:
                this.price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return this.title;
    }

    /**
     * 过多的switch case或者if else语句会使得程序的复杂性提高，可以使用状态模式进行优化
     *
     * @param daysRented
     * @return
     */
    public double getCharge(int daysRented) {
        return this.price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return this.price.getFrequentRenterPoints(daysRented);
    }
}