package com.cjf.bigfilehandle.method2;

/**
 *  * 多线程读、写文件
 *  
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompareTest3 {

    public static void main(String[] args) {
        long millis1 = System.currentTimeMillis();
        System.out.println(millis1);
        Read3 read = new Read3(millis1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 3; i++) {
            service.execute(new Thread(read, "线程" + i));
        }
    }
}

