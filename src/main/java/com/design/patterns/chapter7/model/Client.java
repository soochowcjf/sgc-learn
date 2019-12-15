package com.design.patterns.chapter7.model;

/**
 * @author cjf on 2019/12/15 18:35
 */
public class Client {

    public static void main(String[] args) {
        ConcreteCreator concreteCreator = new ConcreteCreator();
        AbstractProduct product1 = concreteCreator.createProduct(ConcreteProcuct1.class);
        product1.method2();
        AbstractProduct product2 = concreteCreator.createProduct(ConcreteProduct2.class);
        product2.method2();
    }
}
