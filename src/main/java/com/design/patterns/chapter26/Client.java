package com.design.patterns.chapter26;

/**
 * @author cjf on 2020/4/9 20:40
 */
public class Client {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(ILift.STOPPING_STATE);
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
