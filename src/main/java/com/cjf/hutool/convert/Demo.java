package com.cjf.hutool.convert;

/**
 * @author cjf on 2019/12/25 14:57
 */
public class Demo {

    private static final Demo INSTANCE = new Demo();

    public static void main(String[] args) {
//        int a = 1;
//        String s = Convert.toStr(a);
//        System.out.println(s);

//        long[] b = {1, 2, 3, 4, 5};
//        //bStr为："[1, 2, 3, 4, 5]"
//        String bStr = Convert.toStr(b);
//        System.out.println(bStr);

//        String[] b = {"1", "2", "3", "4"};
//        //结果为Integer数组
//        Integer[] intArray = Convert.toIntArray(b);
//        System.out.println(intArray);

    }

    private static class SingletonHolder {
        private static Demo instance = new Demo();
    }
}
