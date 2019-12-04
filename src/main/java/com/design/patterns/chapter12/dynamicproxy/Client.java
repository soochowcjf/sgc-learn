package com.design.patterns.chapter12.dynamicproxy;

import com.design.patterns.chapter12.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author cjf on 2019/12/3 19:23
 */
public class Client {

    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer("张三");
        InvocationHandler handler = new GamePlayIH(gamePlayer);
        ClassLoader classLoader = handler.getClass().getClassLoader();
        Class<?>[] interfaces = gamePlayer.getClass().getInterfaces();
        IGamePlayer iGamePlayer = (IGamePlayer) Proxy.newProxyInstance(classLoader, interfaces, handler);
        iGamePlayer.login("111", "222");
        iGamePlayer.killBoss();
        iGamePlayer.upgrade();
    }
}
