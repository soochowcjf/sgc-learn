package com.design.patterns.chapter7.model;

/**
 * @author cjf on 2019/12/15 18:30
 */
public class ConcreteCreator extends AbstractCreator {
    @Override
    public <T extends AbstractProduct> T createProduct(Class<T> tClass) {
        T product = null;
        try {
            product = (T) Class.forName(tClass.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
