package com.design.patterns.chapter4.enhanced;

import com.design.patterns.chapter4.enhanced.impl.PrettyGirl;
import com.design.patterns.chapter4.enhanced.impl.Searcher;

/**
 * @author cjf on 2019/12/1 22:20
 */
public class Client {

    public static void main(String[] args) {
        PrettyGirl prettyGirl = new PrettyGirl();
        Searcher searcher = new Searcher();
        searcher.show(prettyGirl);
    }
}
