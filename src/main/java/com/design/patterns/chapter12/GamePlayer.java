package com.design.patterns.chapter12;

/**
 * @author cjf on 2019/12/3 17:06
 */
public class GamePlayer implements IGamePlayer {

    private String name;

    /**
     * 代理类
     */
    private IGamePlayer proxy = null;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String name, String password) {
        if (isProxy()) {
            System.out.println("用户：" + name + "\t登陆。。。");
        } else {
            System.out.println("请使用代理类登陆。。。");
        }
    }

    @Override
    public void killBoss() {
        if (isProxy()) {
            System.out.println(this.name + "在打怪。。。");
        } else {
            System.out.println("请使用代理类打怪。。。");

        }
    }

    @Override
    public void upgrade() {
        if (isProxy()) {
            System.out.println(this.name + "在升级。。。");
        } else {
            System.out.println("请使用代理类升级。。。");
        }
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy() {
        return this.proxy != null;
    }
}
