package com.design.patterns.chapter12.dynamicproxy;

import com.design.patterns.chapter12.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 *
 * @author cjf on 2019/12/3 19:19
 */
public class GamePlayIH implements InvocationHandler {

    public static final String ACTION_LOGIN = "login";

    private Object gamePlayer;

    public GamePlayIH(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(gamePlayer, args);
        if (ACTION_LOGIN.equals(method.getName())) {
            System.out.println("用户：" + args[0] + "\t已登录。。。");
        }
        return invoke;
    }
}
