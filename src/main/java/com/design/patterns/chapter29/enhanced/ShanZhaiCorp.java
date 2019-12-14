package com.design.patterns.chapter29.enhanced;

/**
 * @author cjf on 2019/12/14 17:42
 */
public class ShanZhaiCorp extends Corp {

    public ShanZhaiCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("ShanZhaiCorp赚钱了。。。");
    }
}
