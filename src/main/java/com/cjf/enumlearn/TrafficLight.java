package com.cjf.enumlearn;

import org.junit.Test;

/**
 * @author:chenjinfeng
 * Date:2018/5/30
 * Time:21:35
 * 用法二：switch
 */
public class TrafficLight  {
    Signal color = Signal.RED;
    @Test
    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
        System.out.println(color);
    }
}
