package Dao;

import org.apache.ibatis.annotations.*;
import pojo.Activity;
import pojo.Theme;
import pojo.Visitor;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-29 3:31
 * @desc
 */
public interface ActivityMapper {
    /**
     * 查找所有统战信息
     * @return
     */
    @Select("select * from activity")
    List<Activity> selectAllActivity();

    /**
     * 通过ID查找统战信息
     * @param activityID
     * @return
     */
    @Select("select *from activity where activityID = #{activityID}")
    Activity selectByID(int activityID);

    /**
     * 修改统战信息
     * @param activityTitle
     * @param money
     * @param activityBody
     * @param activityID
     *
     */
    @Update("update activity set activityTitle = #{activityTitle}, " +
            "money = #{money}," +
            "activityBody = #{activityBody} where activityID = #{activityID}")
    void update (@Param("activityTitle")String activityTitle,
                 @Param("money")int money,
                 @Param("activityBody")String activityBody,
                 @Param("activityID")int activityID);


    /**
     * 删除统战信息
     * @param activityID
     */
    @Delete("delete  from activity where activityID = #{activityID}")
    void deleteByID(int activityID);

    /**
     * 增加统战信息
     * @param activity
     */
    @Insert("insert into activity(activityID, activityTitle, activityBody, money) VALUES (null,#{activityTitle},#{activityBody},#{money})")
    void add(Activity activity);

    /**
     * 改变统战信息
     * @param activityBody
     * @param activityID
     */
    @Update("update activity set activityBody = #{activityBody} where activityID = #{activityID}")
    void updateActivityBody (@Param("activityBody")String activityBody, @Param("activityID")int activityID);
}
