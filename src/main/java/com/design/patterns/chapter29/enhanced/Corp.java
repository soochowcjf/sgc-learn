package com.design.patterns.chapter29.enhanced;

/**
 * @author cjf on 2019/12/14 17:12
 */
public abstract class Corp {

    private Product product;

    public Corp(Product product) {
        this.product = product;
    }

    /**
     * 赚钱
     */
    public void makeMoney() {
        this.product.beProduced();
        this.product.beSold();
    }
}
