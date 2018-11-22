package com.cjf.netty.chapter9;

/**
 * created by cjf 21:20 2018/11/19
 */
public class User {

    private Integer age;

    private String name;

    public User() {
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
