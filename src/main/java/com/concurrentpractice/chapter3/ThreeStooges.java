package com.concurrentpractice.chapter3;

//import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * ThreeStooges
 * <p/>
 * Immutable class built out of mutable underlying objects,
 * demonstration of candidate for lock elision
 *
 * @author Brian Goetz and Tim Peierls
 */
//@Immutable
public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public static void main(String[] args) {
        ThreeStooges threeStooges = new ThreeStooges();
        threeStooges.stooges.add("chenjinfeng");
        System.out.println(threeStooges.stooges);
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

}
