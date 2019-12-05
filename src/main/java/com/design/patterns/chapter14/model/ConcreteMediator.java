package com.design.patterns.chapter14.model;

/**
 * @author cjf on 2019/12/4 18:56
 */
public class ConcreteMediator extends Mediator {

    @Override
    public void doSomething1() {
        //调用同事类的方法，只要是public方法都可以调用
        super.concreteColleague1.selfMethod1();
        super.concreteColleague2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        super.concreteColleague1.selfMethod1();
        super.concreteColleague2.selfMethod2();
    }
}
