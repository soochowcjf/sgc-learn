package com.hutool.reflect;

import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.ClassUtil;

/**
 * @author cjf on 2019/12/27 10:12
 */
public class Demo {
    private String name;

    public static void main(String[] args) {
//        Method[] methods = ReflectUtil.getMethods(Demo.class);
//        Arrays.stream(methods).forEach(e -> System.out.println(e.getName()));

//        Constructor<Demo> constructor = ReflectUtil.getConstructor(Demo.class);
//        System.out.println(constructor);
//
//        boolean name = ReflectUtil.hasField(Demo.class, "name");
//        System.out.println(name);

        Integer a = 12;
        System.out.println(ClassUtil.isPrimitiveWrapper(a.getClass()));

        System.out.println(ClassUtil.getClassPath());

        Class<?> demo = ClassLoaderUtil.loadClass("demo");
        System.out.println(demo);
    }
}
