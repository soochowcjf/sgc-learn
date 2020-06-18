package com.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author cjf on 2020/4/7 12:32
 */
public class Demo {


    @Test
    public void testSayHi() {
        ServiceLoader<Developer> load = ServiceLoader.load(Developer.class);
        load.forEach(Developer::sayHi);
    }

 }
