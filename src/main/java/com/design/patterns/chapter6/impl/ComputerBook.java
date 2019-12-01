package com.design.patterns.chapter6.impl;

import com.design.patterns.chapter6.IBook;

/**
 * @author cjf on 2019/12/2 0:23
 */
public class ComputerBook implements IBook {

    private String name;
    private int price;
    private String author;
    private String scope;

    public ComputerBook(String name, int price, String author, String scope) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.scope = scope;
    }

    public String getScope() {
        return scope;
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
