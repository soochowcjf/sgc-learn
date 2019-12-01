package com.design.patterns.chapter4;

import com.design.patterns.chapter4.impl.PrettyGirl;
import com.design.patterns.chapter4.impl.Searcher;

/**
 * @author cjf on 2019/12/1 22:10
 */
public class Client {

    public static void main(String[] args) {
        PrettyGirl prettyGirl = new PrettyGirl();
        Searcher searcher = new Searcher();
        searcher.show(prettyGirl);
    }
}
