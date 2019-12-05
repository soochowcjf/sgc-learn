package com.design.patterns.chapter14.model;

/**
 * 中介者
 *
 * @author cjf on 2019/12/4 18:29
 */
public abstract class Mediator {

    protected ConcreteColleague1 concreteColleague1;
    protected ConcreteColleague2 concreteColleague2;

    public ConcreteColleague1 getConcreteColleague1() {
        return concreteColleague1;
    }

    public void setConcreteColleague1(ConcreteColleague1 concreteColleague1) {
        this.concreteColleague1 = concreteColleague1;
    }

    public ConcreteColleague2 getConcreteColleague2() {
        return concreteColleague2;
    }

    public void setConcreteColleague2(ConcreteColleague2 concreteColleague2) {
        this.concreteColleague2 = concreteColleague2;
    }

    /**
     * 中介者业务逻辑1
     */
    public abstract void doSomething1();

    /**
     * 中介者业务逻辑2
     */
    public abstract void doSomething2();
}
