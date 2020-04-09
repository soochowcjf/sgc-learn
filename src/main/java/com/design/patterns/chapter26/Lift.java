package com.design.patterns.chapter26;

/**
 * @author cjf on 2020/4/9 20:39
 */
public class Lift implements ILift {

    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (this.state) {
            case OPENING_STATE:
                //
                break;
            case CLOSING_STATE:
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                //
                break;
            case STOPPING_STATE:
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
            default:
                break;
        }
    }

    @Override
    public void close() {
        switch (this.state) {
            case OPENING_STATE:
                this.closeWithoutLogic();
                this.setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
                //
                break;
            case RUNNING_STATE:
                //
                break;
            case STOPPING_STATE:
                //
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        switch (this.state) {
            case OPENING_STATE:
                //
                break;
            case CLOSING_STATE:
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
            case RUNNING_STATE:
                //
                break;
            case STOPPING_STATE:
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
            default:
                break;
        }
    }

    @Override
    public void stop() {
        switch (this.state) {
            case OPENING_STATE:
                //
                break;
            case CLOSING_STATE:
                this.closeWithoutLogic();
                this.setState(CLOSING_STATE);
                break;
            case RUNNING_STATE:
                this.closeWithoutLogic();
                this.setState(CLOSING_STATE);
                break;
            case STOPPING_STATE:
                //
                break;
            default:
                break;
        }
    }

    private void closeWithoutLogic() {
        System.out.println("电梯门关闭。。。");
    }

    private void openWithoutLogic() {
        System.out.println("电梯门开启。。。");
    }

    private void runWithoutLogic() {
        System.out.println("电梯运行。。。");
    }

    private void stopWithoutLogic() {
        System.out.println("电梯门关闭。。。");
    }
}
