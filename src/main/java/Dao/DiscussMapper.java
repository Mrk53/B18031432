package Dao;

import org.apache.ibatis.annotations.*;
import pojo.Discuss;
import pojo.Theme;
import pojo.Visitor;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-28 3:42
 * @desc
 */
public interface DiscussMapper {
    /**
     * 查看所有讨论
     * @return
     */
    @Select("select * from discuss where themeID = #{themeID}")
    @Results({
            @Result(id=true,column = "discussID",property = "discussID"),
            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
            @Result(column = "themeID",property = "theme",one = @One(select = "Dao.ThemeMapper.selectThemeByID")),
            @Result(column = "discussion",property = "discussion")
    })
    public List<Discuss> selectAllByThemeID(int themeID);


    /**
     * 增加评论
     * @param discussion
     * @param themeID
     * @param visitorID
     */
    @Insert("insert into discuss (discussID,visitorID,themeID,discussion) values(null,#{visitorID},#{themeID},#{discussion})")
    public void addDiscuss(@Param("discussion") String discussion, @Param("themeID")int themeID, @Param("visitorID")int visitorID);

    /**
     * 删除评论
     * @param discussID
     */
    @Delete("delete from discuss where discussID = #{discussID}")
    public void deleteDiscuss(int discussID);


    /**
     * 通过主键查找
     * @param discussID
     * @return
     */
    @Select("select * from discuss where discussID = #{discussID}")
    @Results({
            @Result(id=true,column = "discussID",property = "discussID"),
            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
            @Result(column = "themeID",property = "theme",one = @One(select = "Dao.ThemeMapper.selectThemeByID")),
            @Result(column = "discussion",property = "discussion")
    })
    public Discuss selectByID(int discussID);

    /**
     * 通过发评论者查找
     * @param visitorID
     * @return
     */
    @Select("select * from discuss where visitorID = #{visitorID}")
    @Results({
            @Result(id=true,column = "discussID",property = "discussID"),
            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
            @Result(column = "themeID",property = "theme",one = @One(select = "Dao.ThemeMapper.selectThemeByID")),
            @Result(column = "discussion",property = "discussion")
    })
    public List<Discuss> selectByVisitorID(int visitorID);
}
