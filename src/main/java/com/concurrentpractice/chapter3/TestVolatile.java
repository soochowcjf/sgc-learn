package com.concurrentpractice.chapter3;

/**
 * @author cjf on 2020/4/22 14:28
 */
public class TestVolatile {

    /**
     * 如果使用volatile修饰了之后，
     * 1.会将处理器缓存行的数据写会系统内存
     * 2.这个写回内存的操作会使其他cpu里缓存了该内存地址的数据无效
     */
    private volatile static boolean bChanged;
//    private static boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    System.out.println(bChanged + ":" + bChanged);
                    if (bChanged == !bChanged) {
                        System.out.println("!=");
                        System.exit(0);
                    }
                }
            }
        }.start();
        Thread.sleep(1);
        new Thread() {

            @Override
            public void run() {
                for (; ; ) {
                    bChanged = !bChanged;
                }
            }
        }.start();
    }

}
