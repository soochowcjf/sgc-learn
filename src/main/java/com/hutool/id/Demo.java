package com.hutool.id;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author cjf on 2019/12/27 18:10
 */
public class Demo {
    public static void main(String[] args) {
        String s = IdUtil.randomUUID();
        System.out.println(s);

        String s1 = IdUtil.simpleUUID();
        System.out.println(s1);

        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        long id = snowflake.nextId();
        System.out.println(id);
    }
}
