package com.cjf.enumlearn;

import org.junit.Test;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author:chenjinfeng
 * @Date:2018/5/30
 * @Time:23:12
 * 学习EnumMap
 */
public class TestEnumMap {
    @Test
   public void fun() {
       EnumMap<EnumTest01,String> enumMap = new EnumMap<EnumTest01, String>(EnumTest01.class);
       enumMap.put(EnumTest01.DELETE,"delete");
       enumMap.put(EnumTest01.QUERY,"query");
       enumMap.put(EnumTest01.UPDATE,"update");
        for (Map.Entry<EnumTest01, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey().getEnumDesc()+"---"+entry.getValue());
        }
   }
}
