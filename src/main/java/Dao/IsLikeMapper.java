package Dao;

import org.apache.ibatis.annotations.*;
import pojo.IsLike;
import pojo.Theme;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-05-07 8:41
 * @desc
 */
public interface IsLikeMapper {
    /**
     * 通过点赞者搜索
     * @param visitorID
     * @return
     */
    @Select("select * from isLike where visitorID = #{visitorID} ")
    @Results({
            @Result(id=true,column = "isLikeID",property = "isLikeID"),
            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
            @Result(column = "discussID",property = "discuss",one = @One(select = "Dao.DiscussMapper.selectByID")),
    })
    public List<IsLike> selectIsLikeByVisitor(int visitorID);

    /**
     * 点赞功能
     * @param visitorID
     * @param discussID
     */
    @Insert("insert into isLike (isLikeID,discussID,visitorID) values(null,#{discussID},#{visitorID})")
    public void like(@Param("visitorID") int visitorID,@Param("discussID") int discussID);

    /**
     * 取消点赞功能
     * @param visitorID
     * @param discussID
     */
    @Delete("delete from isLike where visitorID = #{visitorID} and discussID = #{discussID}")
    public void dislike(@Param("visitorID") int visitorID,@Param("discussID") int discussID);

}
