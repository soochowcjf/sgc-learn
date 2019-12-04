package com.design.patterns.chapter12;

/**
 * 代理进行增强，比如这里的计费接口
 *
 * @author cjf on 2019/12/3 17:07
 */
public class GamePlayerProxy implements IGamePlayer, ICount {

    private IGamePlayer gamePlayer;

    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String name, String password) {
        gamePlayer.login(name, password);
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        gamePlayer.upgrade();
        count();
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }

    @Override
    public void count() {
        System.out.println("升级收费：1500元。。。");
    }
}
