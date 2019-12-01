package com.design.patterns.chapter6;

import com.design.patterns.chapter6.impl.ComputerBook;
import com.design.patterns.chapter6.impl.NovelBook;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * @author cjf on 2019/12/2 0:02
 */
public class BookStore {

    public static final ArrayList<IBook> BOOK_STORE = new ArrayList<>();

    static {
        BOOK_STORE.add(new NovelBook("天龙八部", 3200, "金庸"));
        BOOK_STORE.add(new NovelBook("悲惨世界", 5600, "雨果"));
        BOOK_STORE.add(new NovelBook("金瓶梅", 4300, "兰陵"));

        BOOK_STORE.add(new ComputerBook("设计模式", 6500, "小波", "java"));
    }

    public static void main(String[] args) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        System.out.println("---------------书店卖出的书籍如下：---------------");
        BOOK_STORE.forEach(e -> System.out.println("书籍名称：" + e.getName() +
                "\t书籍作者：" + e.getAuthor() +
                "\t书籍价格：" + format.format(e.getPrice() / 100) + "元"));
    }
}
