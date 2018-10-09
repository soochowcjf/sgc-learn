package com.cjf.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author:chenjinfeng
 * @date: 2018/8/24
 * @time: 0:06
 * @desc
 */
public class JsonDemo2 {

    @Test
    public void fun1() {
        //json串
        String s = "{\"id\":\"0375\",\"city\":\"平顶山\"}";
        //转换成javabean
        Weibo weibo = JSONObject.parseObject(s, Weibo.class);
        System.out.println(weibo);
    }

    /**
     * 需要加上static
     */
    public static class Weibo {
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
}
