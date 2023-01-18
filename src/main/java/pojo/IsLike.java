package pojo;

/**
 * @autor Mrk
 * @create 2022-05-07 8:39
 * @desc    点赞表
 */
public class IsLike {
    int isLikeID;
    Discuss discuss;
    Visitor visitor;

    public int getIsLikeID() {
        return isLikeID;
    }

    public void setIsLikeID(int isLikeID) {
        this.isLikeID = isLikeID;
    }

    public Discuss getDiscuss() {
        return discuss;
    }

    public void setDiscuss(Discuss discuss) {
        this.discuss = discuss;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
