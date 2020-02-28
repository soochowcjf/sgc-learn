package com.jvm.classloader;

import org.junit.Test;

/**
 * @author:chenjinfeng
 * @Date:2018/5/31
 * @Time:22:27 参考博客：   https://blog.csdn.net/briblue/article/details/54973413
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

    /**
     * 测试类加载器是哪一个
     */
    @Test
    public void fun() {
        ClassLoader loader = Demo1.class.getClassLoader();
        System.out.println(loader.toString());
//        sun.misc.Launcher$AppClassLoader@b4aac2

        ClassLoader loader1 = int.class.getClassLoader();
        System.out.println(loader1.toString());
//        java.lang.NullPointerException
//        提示的是空指针，意思是int.class这类基础类没有类加载器加载？
//        当然不是！
//        int.class是由Bootstrap ClassLoader加载的。要想弄明白这些，我们首先得知道一个前提。
    }

    @Test
    public void fun2() {
        ClassLoader loader = Demo1.class.getClassLoader();
        //得到父加载器
        ClassLoader parent = loader.getParent();
        System.out.println(loader.toString());
        System.out.println(parent.toString());
//        sun.misc.Launcher$AppClassLoader@b4aac2
//        sun.misc.Launcher$ExtClassLoader@17246de

        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent.toString());
//        java.lang.NullPointerException
//        又是一个空指针异常，这表明ExtClassLoader也没有父加载器。
//        那么，为什么标题又是每一个加载器都有一个父加载器呢？这不矛盾吗？为了解释这一点，我们还需要看下面的一个基础前提。
    }


    /**
     * 大家可以看到2根箭头，蓝色的代表类加载器向上委托的方向，如果当前的类加载器没有查询到这个class对象已经加载就请求父加载器（不一定是父类）进行操作，然后以此类推。
     * 直到Bootstrap ClassLoader。如果Bootstrap ClassLoader也没有加载过此class实例，那么它就会从它指定的路径中去查找，
     * 如果查找成功则返回，如果没有查找成功则交给子类加载器，也就是ExtClassLoader,这样类似操作直到终点，也就是我上图中的红色箭头示例。
     * 用序列描述一下：
     * 1. 一个AppClassLoader查找资源时，先看看缓存是否有，缓存有从缓存中获取，否则委托给父加载器。
     * 2. 递归，重复第1部的操作。
     * 3. 如果ExtClassLoader也没有加载过，则由Bootstrap ClassLoader出面，它首先查找缓存，如果没有找到的话，就去找自己的规定的路径下，
     *      也就是sun.mic.boot.class下面的路径。找到就返回，没有找到，让子加载器自己去找。
     * 4. Bootstrap ClassLoader如果没有查找成功，则ExtClassLoader自己在java.ext.dirs路径中去查找，查找成功就返回，查找不成功，再向下让子加载器找。
     * 5. ExtClassLoader查找不成功，AppClassLoader就自己查找，在java.class.path路径下查找。找到就返回。如果没有找到就让子类找，
     *      如果没有子类会怎么样？抛出各种异常。
     *
     * 上面的序列，详细说明了双亲委托的加载流程。我们可以发现委托是从下向上，然后具体查找过程却是自上至下。
     *
     * 我说过上面用时序图画的让自己不满意，现在用框图，最原始的方法再画一次。
     */

}
