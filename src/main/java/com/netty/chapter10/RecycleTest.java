package com.netty.chapter10;

import io.netty.util.Recycler;

/**
 * created by cjf 22:01 2018/11/23
 * <p>
 * 博客：http://www.mamicode.com/info-detail-2303889.html
 */
public class RecycleTest {

    private static final Recycler<User> RECYCLER = new Recycler<User>() {

        @Override
        protected User newObject(Handle<User> handle) {
            return new User(handle);
        }
    };

    public static class User {
        /**
         * 初始化的时候，Handle设置为DefaultHandle
         */
        private final Recycler.Handle<User> handle;

        User(Recycler.Handle<User> handle) {
            this.handle = handle;
        }

        void recycle() {
            handle.recycle(this);
        }
    }

    public static void main(String[] args) {
        User user = RECYCLER.get();

        user.recycle();

        User user1 = RECYCLER.get();

        System.out.println(user == user1);
        /**
         * true
         */
    }

}
