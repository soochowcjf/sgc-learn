package com.cjf.bigfilehandle.method2;

/**
 * created by cjf 23:51 2018/12/26
 * <p>
 *  * 单线程读、写文件
 *  
 * <p>
 *  * 单线程读、写文件
 *  
 */
/**
  * 单线程读、写文件
  */

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompareTest4 {
    public static void main(String args[]) {

        final long millis1 = System.currentTimeMillis();
        final CyclicBarrier cb = new CyclicBarrier(1, new Runnable() {
            public void run() {
                long millis2 = System.currentTimeMillis();
                System.out.println(millis2);
                System.out.println(millis2 - millis1); //大约1-2ms
            }
        });


        Read4 read = new Read4(cb);
        ExecutorService service = Executors.newFixedThreadPool(1);
        for (int i = 1; i <= 1; i++) {
            service.execute(new Thread(read, "线程" + i));
        }
    }
}