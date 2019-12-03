package com.cjf.annotation.proxy.sta;

import com.cjf.annotation.proxy.Bird;
import org.junit.Test;

/**
 * @author cjf on 2019/10/19 15:36
 */
public class TestDemo {

    @Test
    public void testStaticProxy1() {
        Bird bird = new Bird();
        BirdLogProxy p1 = new BirdLogProxy(bird);
        BirdTimeProxy p2 = new BirdTimeProxy(p1);

        p2.fly();
    }

    @Test
    public void testStaticProxy2() {
        Bird bird = new Bird();
        BirdTimeProxy p2 = new BirdTimeProxy(bird);
        BirdLogProxy p1 = new BirdLogProxy(p2);

        p1.fly();
    }
}

