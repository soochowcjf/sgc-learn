package com.java8.java8shizhan.chap3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author:chenjinfeng
 * @date: 2018/8/6
 * @time: 23:08
 * @desc
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    /**
     * 函数式接口中的唯一方法
     */
    String processFile(BufferedReader br) throws IOException;
}
