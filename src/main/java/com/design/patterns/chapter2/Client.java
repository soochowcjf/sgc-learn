package com.design.patterns.chapter2;

import com.design.patterns.chapter2.abstractgunimpl.HandGun;
import com.design.patterns.chapter2.abstractgunimpl.Rifle;
import com.design.patterns.chapter2.abstractgunimpl.rifleextends.AUG;

/**
 * @author cjf on 2019/12/1 20:54
 */
public class Client {

    public static void main(String[] args) {
        HandGun handGun = new HandGun();
        Soldier soldier = new Soldier(handGun);
        soldier.killEnemy();

        Rifle rifle = new Rifle();
        Soldier soldier1 = new Soldier(rifle);
        soldier1.killEnemy();

        AUG aug = new AUG();
        Snipper snipper = new Snipper(aug);
        snipper.killEnemy();
    }
}
