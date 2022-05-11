package 蚕食拖延;

public class NDDelay {
    private int delayCount;
    private int actionCount;

    public static void main(String[] args) {

    }

    public NDDelay(int delayCount, int rightNow) {
        this.delayCount = delayCount;
        this.actionCount = rightNow;
    }

    public NDDelay() {
        this.delayCount = 0;
        this.actionCount = 0;
    }


    public int getDelayCount() {
        return delayCount;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void setDelayCount(int delayCount) {
        this.delayCount = delayCount;
    }

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }


    public void addDelay() {
        delayCount++;
    }

    public void addRightNow() {
        actionCount++;
    }
}
