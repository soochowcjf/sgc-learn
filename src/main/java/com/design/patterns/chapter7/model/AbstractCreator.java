package com.design.patterns.chapter7.model;

/**
 * @author cjf on 2019/12/15 18:27
 */
public abstract class AbstractCreator {

    /**
     * 生产产品
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public abstract <T extends AbstractProduct> T createProduct(Class<T> tClass);
}
