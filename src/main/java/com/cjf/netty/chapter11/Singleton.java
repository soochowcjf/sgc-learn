package com.cjf.netty.chapter11;

import io.netty.handler.codec.mqtt.MqttEncoder;
import io.netty.handler.timeout.ReadTimeoutException;

/**
 * created by cjf 15:01 2018/11/24
 *
 *  @see ReadTimeoutException
 *  @see MqttEncoder
 *
 *  单类模式：写法可以参照ReadTimeoutException,MqttEncoder这两种的写法
 */
public class Singleton {

    private static Singleton singleton;

    //私有构造函数
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
