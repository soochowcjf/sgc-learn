package com.design.patterns.chapter12.dynamicproxy;

import com.design.patterns.chapter12.IGamePlayer;

/**
 * @author cjf on 2019/12/3 19:31
 */
public class GamePlayer implements IGamePlayer {

    private String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String name, String password) {
        System.out.println("用户：" + name + "\t登陆。。。");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪。。。");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + "在升级。。。");
    }

    @Override
    public IGamePlayer getProxy() {
        return null;
    }
}
