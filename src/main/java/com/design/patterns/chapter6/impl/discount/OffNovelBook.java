package com.design.patterns.chapter6.impl.discount;

import com.design.patterns.chapter6.impl.NovelBook;

/**
 * @author cjf on 2019/12/2 0:14
 */
public class OffNovelBook extends NovelBook {

    public OffNovelBook(String name, int price, String author) {
        super(name, price, author);
    }

    @Override
    public int getOffPrice() {
        int price = super.getPrice();
        int offPrice = 0;
        if (price > 4000) {
            offPrice = price * 90 / 100;
        } else {
            offPrice = price * 80 / 100;
        }
        return offPrice;
    }
}
