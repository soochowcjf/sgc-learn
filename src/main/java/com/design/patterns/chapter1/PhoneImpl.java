package com.design.patterns.chapter1;

/**
 * @author cjf on 2019/12/1 20:33
 */
public class PhoneImpl implements IPhone {

    @Override
    public void dial(String phoneNumber) {
        System.out.println("拨通号码：" + phoneNumber);
    }

    @Override
    public void chat(Object o) {
        System.out.println("通话：" + o);
    }

    @Override
    public void hangup() {
        System.out.println("挂断!!!");
    }
}
