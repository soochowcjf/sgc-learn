package com.design.refactor.chapter1.ver3;

import com.design.refactor.chapter1.ver1.Movie;
import org.junit.Test;

/**
 * @author cjf on 2020/4/8 12:44
 */
public class TestDemo {

    @Test
    public void testStatement() {
        Customer customer = new Customer("陈金烽");
        String title = "泰坦尼克号";
        int priceCode = 2;
        Movie movie = new Movie(title, priceCode);
        int daysRented = 7;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);
        String result = customer.statement();
        System.out.println(result);
    }
}
