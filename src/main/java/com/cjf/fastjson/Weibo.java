package com.cjf.fastjson;

/**
 * author:chenjinfeng
 * Date:2018/5/28
 * Time:21:56
 */
public class Weibo {
    private String id;
    private String city;

    public Weibo(String id, String city) {
        this.id = id;
        this.city = city;
    }

    public Weibo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Weibo{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
