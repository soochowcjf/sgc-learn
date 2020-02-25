package com.cjf.hutool.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.*;
import cn.hutool.core.lang.Console;

import java.util.Date;
import java.util.List;

/**
 * @author cjf on 2019/12/25 18:58
 */
public class DateDemo {

    public static void main(String[] args) {
        String a = "2017-05-06";
        Date value = Convert.toDate(a);
        System.out.println(value);

        Object[] b = {"a", "你", "好", "", 1};
        List<?> list = Convert.toList(b);
        System.out.println(list);

        String str = "\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32";
        String s = Convert.unicodeToStr(str);
        System.out.println(s);

        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        //结果：2017-03-03 22:33:23
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        System.out.println(newDate);

        //常用偏移，结果：2017-03-04 22:33:23
        DateTime newDate2 = DateUtil.offsetDay(date, 3);
        System.out.println(newDate2);

        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);

        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        Console.log(betweenDay);
        //Level.MINUTE表示精确到分
        String formatBetween = DateUtil.formatBetween(betweenDay, BetweenFormater.Level.MINUTE);
        //输出：31天1小时
        Console.log(formatBetween);
    }
}
