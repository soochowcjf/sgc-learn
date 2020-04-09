package com.design.patterns.chapter26.enhanced;

/**
 * @author cjf on 2020/4/9 22:25
 */
public abstract class LiftState {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();


}
