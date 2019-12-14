package com.design.patterns.chapter29;

/**
 * @author cjf on 2019/12/14 17:16
 */
public class Client {

    public static void main(String[] args) {
        HouseCorp houseCorp = new HouseCorp();
        houseCorp.makeMoney();

        ClothesCorp clothesCorp = new ClothesCorp();
        clothesCorp.makeMoney();
    }
}
