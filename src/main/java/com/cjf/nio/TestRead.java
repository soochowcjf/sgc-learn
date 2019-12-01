package com.cjf.nio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * created by cjf 13:58 2019/1/26
 */
public class TestRead {

    @Test
    public void fun() throws Exception {

        String fileSource = "C:\\Users\\Mr Chen\\Desktop\\文件处理\\submit_status\\sgip\\status_177.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileSource));
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            count++;
        }
        System.out.println(count);
        br.close();
    }
}
