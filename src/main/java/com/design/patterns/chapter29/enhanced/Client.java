package com.design.patterns.chapter29.enhanced;

/**
 * @author cjf on 2019/12/14 17:39
 */
public class Client {

    public static void main(String[] args) {
        Corp corp = new ShanZhaiCorp(new IPod());
        corp.makeMoney();
    }
}
