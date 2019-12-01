package com.design.patterns.chapter2;

/**
 * @author cjf on 2019/12/1 20:52
 */
public class Soldier {

    private AbstractGun abstractGun;

    public Soldier(AbstractGun abstractGun) {
        this.abstractGun = abstractGun;
    }

    public void killEnemy() {
        System.out.println("士兵开始杀人。。。");
        abstractGun.shoot();
    }
}
