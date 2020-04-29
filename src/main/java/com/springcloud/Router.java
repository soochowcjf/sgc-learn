package com.springcloud;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public final class Router {
    private final String ip;
    private final Integer port;
    private final String iface;

    public Router(String ip, Integer port, String iface) {
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, blockingQueue, new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "sgc_thread_" + this.threadIndex.incrementAndGet());
            }
        }, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new TestRun());
        }
        threadPoolExecutor.shutdown();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Router) {
            Router r = (Router) obj;
            return iface.equals(r.iface) &&
                    ip.equals(r.ip) &&
                    port.equals(r.port);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, iface);
    }

    /**
     * 路由表信息
     */
    public class RouterTable {
        /**
         * Key:接口名
         * Value:路由集合
         */
        ConcurrentHashMap<String, CopyOnWriteArraySet<Router>> rt = new ConcurrentHashMap<>();

        /**
         * 根据接口名获取路由表
         */
        public Set<Router> get(String iface) {
            return rt.get(iface);
        }

        /**
         * 删除路由
         */
        public void remove(Router router) {
            Set<Router> set = rt.get(router.iface);
            if (set != null) {
                set.remove(router);
            }
        }

        /**
         * 增加路由
         */
        public void add(Router router) {
            Set<Router> set = rt.computeIfAbsent(router.iface, r -> new CopyOnWriteArraySet<>());
            set.add(router);
        }
    }

}
