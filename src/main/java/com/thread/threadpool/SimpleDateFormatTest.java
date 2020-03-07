package com.thread.threadpool;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author cjf on 2020/1/20 13:43
 */
public class SimpleDateFormatTest {
    //(1)创建单例实例
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        //(2)创建多个线程，并启动
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(() -> {
                try {//(3)使用单例日期实例解析文本
                    System.out.println(sdf.parse("2017-12-13"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            thread.start();//(4)启动线程
        }
    }
}
