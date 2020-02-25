package com.datastructure;

import java.util.BitSet;

/**
 * @author cjf on 2020/2/15 14:24
 */
public class BigSetDemo {

    private static final BitSet TOKEN = new BitSet(128);

    public static void main(String[] args) {
        // variable names refer to RFC 2616, section 2.2
        BitSet ctl = new BitSet(128);
        for (int i = 0; i <= 31; i++) {
            ctl.set(i);
        }

        System.out.println(ctl.get(30));
        ctl.set(127);

        BitSet separators = new BitSet(128);
        separators.set('(');
        separators.set(')');
        separators.set('<');
        separators.set('>');
        separators.set('@');
        separators.set(',');
        separators.set(';');
        separators.set(':');
        separators.set('\\');
        separators.set('\"');
        separators.set('/');
        separators.set('[');
        separators.set(']');
        separators.set('?');
        separators.set('=');
        separators.set('{');
        separators.set('}');
        separators.set(' ');
        separators.set('\t');

        TOKEN.set(0, 128);
        TOKEN.andNot(ctl);
        TOKEN.andNot(separators);
        System.out.println(TOKEN.get(127));
        System.out.println(TOKEN.get(0));
    }
}
