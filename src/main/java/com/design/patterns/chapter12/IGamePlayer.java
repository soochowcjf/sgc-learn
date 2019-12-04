package com.design.patterns.chapter12;

/**
 * @author cjf on 2019/12/3 17:02
 */
public interface IGamePlayer {

    /**
     * 登陆
     *
     * @param name
     * @param password
     */
    void login(String name, String password);

    /**
     * 打怪
     */
    void killBoss();

    /**
     * 升级
     */
    void upgrade();

    /**
     * 获取代理类
     *
     * @return
     */
    IGamePlayer getProxy();
}
