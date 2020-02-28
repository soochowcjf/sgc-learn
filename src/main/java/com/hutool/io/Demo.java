package com.hutool.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

/**
 * @author cjf on 2019/12/26 14:10
 */
public class Demo {

    public static void main(String[] args) throws Exception {

        BufferedInputStream in = FileUtil.getInputStream("d:/test.txt");
        BufferedOutputStream out = FileUtil.getOutputStream("d:/test2.txt");
        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
        IoUtil.close(out);
        IoUtil.close(in);
    }
}
