package com.design.patterns.chapter18;

/**
 * @author cjf on 2019/12/6 16:33
 */
public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开绿灯。。。");
    }
}
