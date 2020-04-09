package com.design.refactor.chapter1.ver1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    /**
     * 姓名
     */
    private String name;
    /**
     * 租借记录
     */
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        // 总消费金
        double totalAmount = 0;
        // 常客积点
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (rentals.hasMoreElements()) {
            // 取得一笔租借记。
            Rental each = rentals.nextElement();
            // determine amounts for each line
            // 取得影片出租价格
            double thisAmount = amountFor(each);
            // add frequent renter points （累计常客积点。
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental（显示此笔租借记录）
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        // add footer lines（结尾打印）
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            // 普通片
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            // 新片
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            // 儿童
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return thisAmount;
    }
}