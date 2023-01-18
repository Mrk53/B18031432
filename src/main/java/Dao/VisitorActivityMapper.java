package Dao;

import org.apache.ibatis.annotations.*;
import pojo.Discuss;
import pojo.VisitorActivity;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-29 3:36
 * @desc
 */
public interface VisitorActivityMapper {
    /**
     * 通过用户查找活动
     * @return
     */
    @Select("select * from visitorActivity where visitorID = #{visitorID}")
    @Results({
            @Result(id=true,column = "visitorActivityID",property = "visitorActivityID"),
            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
            @Result(column = "activityID",property = "activity",one = @One(select = "Dao.ActivityMapper.selectByID"))
    })
    public List<VisitorActivity> selectAllByVisitorID(int visitorID);

    /**
     * 通过活动查找用户
     * @param activityID
       * @return
     */
    @Select("select * from visitorActivity where activityID = #{activityID}")
    @Results({
            @Result(id=true,column = "visitorActivityID",property = "visitorActivityID"),
            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
            @Result(column = "activityID",property = "activity",one = @One(select = "Dao.ActivityMapper.selectByID"))
    })
    public List<VisitorActivity> selectAllByActivityID(int activityID);

    /**
     * 添加活动用户
     * @param activityID
     * @param visitorID
     */
    @Insert("insert into visitorActivity (visitorActivityID,visitorID,activityID) values (null,#{visitorID},#{activityID})")
    public void addVisitorToActivity(@Param("activityID") int activityID,@Param("visitorID") int visitorID);

    /**
     * 删除活动用户
     * @param activityID
     * @param visitorID
     */
    @Delete("delete from visitorActivity where activityID = #{activityID} and visitorID = #{visitorID}")
    public void deleteVisitorOfActivity(@Param("activityID") int activityID,@Param("visitorID") int visitorID);

}
