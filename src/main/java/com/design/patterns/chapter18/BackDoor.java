package com.design.patterns.chapter18;

/**
 * @author cjf on 2019/12/6 16:33
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙。。。");
    }
}
