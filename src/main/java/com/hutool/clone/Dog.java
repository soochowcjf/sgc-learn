package com.hutool.clone;

import cn.hutool.core.clone.CloneSupport;
import lombok.Getter;

/**
 * @author cjf on 2019/12/25 14:26
 */
@Getter
public class Dog extends CloneSupport<Dog> {
    private String name = "wangwang";
    private int age = 3;

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.getName() + " : " + dog.getAge());
    }
}
