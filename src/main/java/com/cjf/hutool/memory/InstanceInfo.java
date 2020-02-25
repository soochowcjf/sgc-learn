package com.cjf.hutool.memory;

import java.util.Date;

/**
 * Lei Xu
 * 2017/12/7
 * 11:55
 */
public class InstanceInfo<I, K> {
    private K key;
    private I instance;

    //有效时间,毫秒
    private long validPeriod;
    //载入时间
    private Date loadTime;

    //此缓存是否已经超出
    public boolean isValid() {
        return loadTime.getTime() + validPeriod >= System.currentTimeMillis();
    }

    public I getInstance() {
        return instance;
    }

    public void setInstance(I instance, long validPeriod, Date loadTime) {
        this.instance = instance;
        this.validPeriod = validPeriod;
        this.loadTime = loadTime;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public long getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(long validPeriod) {
        this.validPeriod = validPeriod;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
    }
}
