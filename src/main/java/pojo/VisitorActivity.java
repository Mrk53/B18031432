package pojo;

/**
 * @autor Mrk
 * @create 2022-04-29 3:33
 * @desc
 */
public class VisitorActivity {
    private int visitorActivityID;
    private Visitor visitor;
    private Activity activity;

    public int getVisitorActivityID() {
        return visitorActivityID;
    }

    public void setVisitorActivityID(int visitorActivityID) {
        this.visitorActivityID = visitorActivityID;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
