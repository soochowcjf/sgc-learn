package com.design.patterns.chapter6.impl;

import com.design.patterns.chapter6.IBook;

/**
 * @author cjf on 2019/12/2 0:00
 */
public class NovelBook implements IBook {

    private String name;
    private int price;
    private String author;

    public NovelBook(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getAuthor() {
        return author;
    }

}
