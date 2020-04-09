package com.design.refactor.chapter1.ver5;

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
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (rentals.hasMoreElements()) {
            // 取得一笔租借记。
            Rental each = rentals.nextElement();
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getCharge()).append("\n");
        }

        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental rental = elements.nextElement();
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental rental = elements.nextElement();
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}