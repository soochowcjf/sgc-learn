package com.concurrentpractice.stm;

/**
 * 带版本号的对象引⽤
 */
public final class VersionedRef<T> {

    final T value;
    final long version;

    public VersionedRef(T value, long version) {
        this.value = value;
        this.version = version;
    }
}