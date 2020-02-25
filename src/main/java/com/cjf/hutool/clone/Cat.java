package com.cjf.hutool.clone;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.Cloneable;
import lombok.Data;

/**
 * @author cjf on 2019/12/25 14:03
 */
@Data
public class Cat implements Cloneable<Cat> {
    private String name = "miaomiao";
    private int age = 2;

    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat clone = cat.clone();
        System.out.println(clone.getName() + " : " + clone.getAge());
    }

    @Override
    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}
