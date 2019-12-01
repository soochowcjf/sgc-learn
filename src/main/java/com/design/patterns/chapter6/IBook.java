package com.design.patterns.chapter6;

/**
 * @author cjf on 2019/12/1 23:58
 */
public interface IBook {

    /**
     * 姓名
     *
     * @return
     */
    String getName();

    /**
     * 价格
     *
     * @return
     */
    int getPrice();

    /**
     * 作者
     *
     * @return
     */
    String getAuthor();

    /**
     * 后期添加的打折后的价格
     *
     * @return
     */
    default int getOffPrice() {
        return 0;
    }
}
