package com.design.patterns.chapter13.model;

/**
 * @author cjf on 2019/12/4 15:47
 */
public class PrototypeClass implements Cloneable {

    @Override
    protected PrototypeClass clone() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = null;

        try {
            prototypeClass = (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            //异常处理
        }
        return prototypeClass;
    }
}
