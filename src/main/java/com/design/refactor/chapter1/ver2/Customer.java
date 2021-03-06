package com.design.refactor.chapter1.ver2;

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

            // 取得影片出租价格
//            double thisAmount = amountFor(each);
            double thisAmount = each.getCharge();

            frequentRenterPoints += each.getFrequentRenterPoints();

//            frequentRenterPoints++;
//            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
//                    && each.getDaysRented() > 1) {
//                frequentRenterPoints++;
//            }

            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

//    private double amountFor(Rental each) {
//        return each.getCharge();
//    }
}