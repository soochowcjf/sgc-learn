package com.design.patterns.chapter18;

/**
 * @author cjf on 2019/12/6 16:36
 */
public class Client {
    public static void main(String[] args) {

        BlockEnemy blockEnemy = new BlockEnemy();
        Context context = new Context(blockEnemy);
        context.operate();
    }
}
