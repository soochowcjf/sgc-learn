package com.design.patterns.chapter13.attention;

import java.util.ArrayList;

/**
 * 对象的clone和对象内的final关键字存在冲突
 *
 * @author cjf on 2019/12/4 16:07
 */
public class Thing3 implements Cloneable {

    //    private final ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<String> arrayList = new ArrayList<>();

    /**
     * 深拷贝
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Thing3 clone() throws CloneNotSupportedException {
        Thing3 thing3 = null;
        try {
            thing3 = (Thing3) super.clone();
            thing3.arrayList = (ArrayList<String>) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            //
        }
        return thing3;
    }
}
