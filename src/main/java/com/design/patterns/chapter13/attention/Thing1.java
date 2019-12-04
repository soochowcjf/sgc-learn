package com.design.patterns.chapter13.attention;

/**
 * 构造函数不会被执行
 *
 * @author cjf on 2019/12/4 15:53
 */
public class Thing1 implements Cloneable {

    public Thing1() {
        System.out.println("构造函数被执行了。。。");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Thing1 thing1 = new Thing1();
        thing1.clone();
    }

    @Override
    protected Thing1 clone() throws CloneNotSupportedException {
        Thing1 thing1 = null;
        try {
            thing1 = (Thing1) super.clone();
        } catch (CloneNotSupportedException e) {
            //
        }
        return thing1;
    }
}
