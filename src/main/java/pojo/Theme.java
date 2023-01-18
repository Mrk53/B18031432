package pojo;

import java.util.Objects;

/**
 * @autor Mrk
 * @create 2022-04-26 19:38
 * @desc    议政主题
 */
public class Theme {
    private int themeID;
    private Visitor visitor;
    private String themeTitle;
    private String themeBody;
    private int isBest;

    public int getIsBest() {
        return isBest;
    }

    public void setIsBest(int isBest) {
        this.isBest = isBest;
    }

    public int getThemeID() {
        return themeID;
    }

    public void setThemeID(int themeID) {
        this.themeID = themeID;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }

    public String getThemeBody() {
        return themeBody;
    }

    public void setThemeBody(String themeBody) {
        this.themeBody = themeBody;
    }
}
