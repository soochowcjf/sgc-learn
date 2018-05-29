package com.alibaba.DateTransLearn;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:chenjinfeng
 * Date:2018/5/29
 * Time:22:18
 * 日期格式转换
 */
public class DateTransDemo {

    /**
     * Date转换成String
     */
    @Test
    public void date2Str() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(now);
        System.out.println(s);
    }
    /**
     * String转换成Date
     */
    @Test
    public void str2Date() {
        String str = "2018-05-29 22:23:45";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * 时间戳转换成Date或String
     */
    @Test
    public void stamp2DateOrStr() {
        String stamp = "1520225508000";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = Long.parseLong(stamp);
        //时间戳转换成string
        String str = simpleDateFormat.format(time);
        System.out.println(str);
        try {
            //时间戳转换成Date
            Date date = simpleDateFormat.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * Date或String转换成时间戳
     */
    @Test
    public void dateOrStr2Stamp() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2018-03-05 12:51:48";
        Date date = simpleDateFormat.parse(str);
        long stamp = date.getTime();
        System.out.println(stamp);
    }
}
