package com.design.patterns.chapter2.abstractgunimpl;

import com.design.patterns.chapter2.AbstractGun;

/**
 * @author cjf on 2019/12/1 20:51
 */
public class MachineGun extends AbstractGun {
    @Override
    public void shoot() {
        System.out.println("机枪射击。。。");
    }
}
