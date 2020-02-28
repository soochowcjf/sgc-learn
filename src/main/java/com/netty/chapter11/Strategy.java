package com.netty.chapter11;

import io.netty.util.concurrent.DefaultEventExecutorChooserFactory;
import io.netty.util.concurrent.EventExecutor;

/**
 * created by cjf 15:21 2018/11/24
 * <p>
 * 策略模式
 *
 * @see DefaultEventExecutorChooserFactory#newChooser(EventExecutor[])
 */
public class Strategy {

    private Cache cacheMemory = new CacheMemoryImpl();
    private Cache cacheRedis = new CacheRedisImpl();

    public interface Cache {
        boolean add(String key, String value);
    }

    public class CacheMemoryImpl implements Cache {

        @Override
        public boolean add(String key, String value) {
            //保存到内存中
            return true;
        }
    }

    public class CacheRedisImpl implements Cache {

        @Override
        public boolean add(String key, String value) {
            //保存到redis中
            return true;
        }
    }

    /**
     * 选择哪一种缓存策略
     */
    public Cache getCache(String key) {
        if (key.length() < 10) {
            return cacheRedis;
        }
        return cacheMemory;
    }

}
