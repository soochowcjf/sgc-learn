package com.springcloud;

/**
 * @author cjf on 2020/3/5 19:32
 */
public enum ClockWithOffset implements Clock {
    /**
     * 单类
     */
    INSTANCE;

    private volatile long offset;

    public void setOffset(long offset) {
        this.offset = offset;
    }

    @Override
    public long now() {
        return offset + System.currentTimeMillis();
    }

}
