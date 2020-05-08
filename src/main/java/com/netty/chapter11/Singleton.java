package com.netty.chapter11;

import io.netty.handler.codec.mqtt.MqttEncoder;
import io.netty.handler.timeout.ReadTimeoutException;

/**
 * created by cjf 15:01 2018/11/24
 *
 * @see ReadTimeoutException
 * @see MqttEncoder
 * <p>
 * 单类模式：写法可以参照ReadTimeoutException,MqttEncoder这两种的写法
 */
public class Singleton {

    private static volatile Singleton singleton;

    //私有构造函数
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    /**
                     * 1.分配一块内存M
                     * 2.在内存M上初始化Singleton
                     * 3.然后M的地址赋值给singleton
                     *
                     * 但是实际上优化后的执行路径却是这样的：
                     * 1. 分配一块内存 M；
                     * 2. 将 M 的地址赋值给 instance 变量；
                     * 3. 最后在内存 M 上初始化 Singleton 对象。
                     */
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
