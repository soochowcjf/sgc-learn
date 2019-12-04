package com.design.patterns.chapter14.model;

/**
 * @author cjf on 2019/12/4 18:39
 */
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod2() {

    }

    public void depMethod2() {
        super.mediator.doSomething2();
    }
}
