package com.cjf.enumlearn;

import org.junit.Test;

/**
 * @author:chenjinfeng
 * @Date:2018/5/30
 * @Time:22:22
 * 用法六：使用接口组织枚举
 */
public class TestM6 {
    
    @Test
    public void testImplementsInterface() {
        for (Dessert dessert : Dessert.values()) {
            System.out.println(dessert);
        }
    }
    //搞个实现接口，来组织枚举，简单讲，就是分类吧。如果大量使用枚举的话，这么干，在写代码的时候，就很方便调用啦。
    //还有就是个“多态”的功能吧
    @Test
    public void test2() {
        Food food = Dessert.CAKE;
        System.out.println(food);
        food = Coffee.DECAF_COFFEE;
        System.out.println(food);
    }

}
