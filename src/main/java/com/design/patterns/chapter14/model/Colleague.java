package com.design.patterns.chapter14.model;

/**
 * 同事类
 *
 * @author cjf on 2019/12/4 18:33
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
