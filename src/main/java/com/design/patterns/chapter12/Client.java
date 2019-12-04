package com.design.patterns.chapter12;

/**
 * @author cjf on 2019/12/3 17:15
 */
public class Client {
    public static void main(String[] args) {
//        GamePlayer gamePlayer = new GamePlayer("张三");
//        GamePlayerProxy gamePlayerProxy = new GamePlayerProxy(gamePlayer);
//        gamePlayerProxy.login("李四", "123");
//        gamePlayerProxy.killBoss();
//        gamePlayerProxy.upgrade();


//        GamePlayer gamePlayerProxy = new GamePlayer("王五");
//        GamePlayerProxy gamePlayerProxy = new GamePlayerProxy(gamePlayer);
        GamePlayer gamePlayer = new GamePlayer("王五");
        IGamePlayer gamePlayerProxy = gamePlayer.getProxy();
        gamePlayerProxy.login("赵六", "456");
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();
    }
}
