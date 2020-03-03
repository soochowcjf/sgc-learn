package com.lru;

import org.junit.Test;

/**
 * @author cjf on 2020/3/3 20:16
 */
public class TestDemo {

    @Test
    public void fun1() {
        LRUCache2<String, Object> cache = new LRUCache2<>(3);

        cache.put("chenjinfeng", 25);
        cache.put("kanjie", 24);
        cache.put("lihaiyuan", 23);
        cache.put("liuyue", 22);
    }
}
