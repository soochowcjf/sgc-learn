package com.hutool.memory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Lei Xu
 * 2017/12/7
 * 11:54
 */
public abstract class InstanceMemoryContainer<I, K> {

    //	public static final Logger logger = LoggerFactory.getLogger(InstanceMemoryContainer.class);
    //内存缓存
    private Map<K, InstanceInfo<I, K>> instanceInfoMap = new HashMap<>();

    public I getInstance(K key) {
        InstanceInfo<I, K> ikInstanceInfo = instanceInfoMap.get(key);

        if (ikInstanceInfo == null || !ikInstanceInfo.isValid()) {
            I load = load(key);
            if (load == null) {
//				logger.error("加载失败");
                //有老数据就取老数据
                return ikInstanceInfo == null ? null : ikInstanceInfo.getInstance();
            }
            if (ikInstanceInfo == null) {
                ikInstanceInfo = new InstanceInfo<>();
            }
            ikInstanceInfo.setKey(key);
            ikInstanceInfo.setInstance(load, getValid(), new Date());
            instanceInfoMap.put(key, ikInstanceInfo);
        }
        return ikInstanceInfo.getInstance();
    }

    /**
     * 从存储体（非缓存,但如果对象数据在数据库，推荐使用原生springcache）中加载所需对象
     *
     * @param key
     * @return
     */
    protected abstract I load(K key);

    //Default: 5min
    public long getValid() {
        return 1000 * 60 * 5;
    }
}
