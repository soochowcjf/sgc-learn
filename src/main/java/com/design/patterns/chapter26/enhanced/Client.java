package com.design.patterns.chapter26.enhanced;

/**
 * @author cjf on 2020/4/9 22:39
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
