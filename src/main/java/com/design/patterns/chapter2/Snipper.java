package com.design.patterns.chapter2;

import com.design.patterns.chapter2.abstractgunimpl.rifleextends.AUG;

/**
 * @author cjf on 2019/12/1 21:08
 */
public class Snipper {

    private AUG aug;

    /**
     * 传递具体的子类，只有子类才就有特性
     */
    public Snipper(AUG aug) {
        this.aug = aug;
    }

    public void killEnemy() {
        System.out.println("狙击手开始杀人。。。");
        aug.zoomOut();
        aug.shoot();
    }
}
