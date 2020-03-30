package com.concurrentpractice.chapter4;

import javax.annotation.concurrent.ThreadSafe;
import java.util.HashSet;
import java.util.Set;

/**
 * 通过封闭机制来确保线程安全
 *
 * @author cjf on 2020/3/27 17:01
 */
@ThreadSafe
public class PersonSet {
    private final Set<Person> myset = new HashSet<>();

    public synchronized void addPerson(Person p) {

    }

    public synchronized boolean containsPerson(Person p) {
        return myset.contains(p);
    }

    public static class Person {
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
