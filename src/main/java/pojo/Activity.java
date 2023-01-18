package pojo;

/**
 * @autor Mrk
 * @create 2022-04-29 3:28
 * @desc
 */
public class Activity {
    private int activityID ;
    private String activityTitle;
    private String activityBody;
    private int money ;

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityBody() {
        return activityBody;
    }

    public void setActivityBody(String activityBody) {
        this.activityBody = activityBody;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
