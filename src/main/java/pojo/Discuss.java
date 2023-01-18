package pojo;

import java.util.Objects;

/**
 * @autor Mrk
 * @create 2022-04-26 19:41
 * @desc    议政回复
 */
public class Discuss {
    private int discussID;
    private Visitor visitor;
    private Theme theme;
    private String discussion;

    public int getDiscussID() {
        return discussID;
    }

    public void setDiscussID(int discussID) {
        this.discussID = discussID;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }
}
