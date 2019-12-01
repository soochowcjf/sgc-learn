package com.design.patterns.chapter6.impl.discount;

import com.design.patterns.chapter6.IBook;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * @author cjf on 2019/12/2 0:02
 */
public class BookStore {

    public static final ArrayList<IBook> BOOK_STORE = new ArrayList<>();

    static {
        BOOK_STORE.add(new OffNovelBook("天龙八部", 3200, "金庸"));
        BOOK_STORE.add(new OffNovelBook("悲惨世界", 5600, "雨果"));
        BOOK_STORE.add(new OffNovelBook("金瓶梅", 4300, "兰陵"));
    }

    public static void main(String[] args) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        System.out.println("---------------书店卖出的书籍如下：---------------");
        BOOK_STORE.forEach(e -> System.out.println("书籍名称：" + e.getName() +
                "\t书籍作者：" + e.getAuthor() +
                "\t书籍原价：" + format.format(e.getPrice() / 100) + "元" +
                "\t书籍折后价：" + format.format(e.getOffPrice() / 100) + "元"));
    }
}
