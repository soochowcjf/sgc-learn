package com.design.patterns.chapter2.abstractgunimpl.rifleextends;

import com.design.patterns.chapter2.abstractgunimpl.Rifle;

/**
 * @author cjf on 2019/12/1 21:06
 */
public class AUG extends Rifle {

    public void zoomOut() {
        System.out.println("望远镜瞄准。。。");
    }

    @Override
    public void shoot() {
        System.out.println("AUG射击。。。");
    }
}

