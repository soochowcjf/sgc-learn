package com.java8.java8shizhan.chap3;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author:chenjinfeng
 * @date: 2018/8/6
 * @time: 23:11
 * @desc
 */
public class LambdaTest {

    /**
     * 处理文件的方法
     *
     * @param bufferedReaderProcessor
     */
    public String processFile(BufferedReaderProcessor bufferedReaderProcessor) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("d:/testnio/1.txt"));
            String s = bufferedReaderProcessor.processFile(br);
            br.close();
            return s;
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void test() {
        String s = processFile((br) -> br.readLine() + br.readLine());
        System.out.println(s);
    }
}
