package Dao;

import org.apache.ibatis.annotations.*;
import pojo.Theme;
import pojo.Visitor;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-26 19:47
 * @desc
 */
public interface ThemeMapper {
    /**
     * 查看所有主题
     * @return
     */
    @Select("select * from theme")
    @Results({
            @Result(id=true,column = "themeID",property = "themeID"),
            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
            @Result(column = "themeTitle",property = "themeTitle"),
            @Result(column = "themeBody",property = "themeBody")
    })
    List<Theme> selectAllTheme();

//    /**
//     * 查找自己的主题
//     * @param theme
//     * @return
//     */
//    @Select("select * from theme where themeID = #{themeID}")
//    @Results({
//            @Result(id=true,column = "themeID",property = "themeID"),
//            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
//            @Result(column = "themeTitle",property = "themeTitle"),
//            @Result(column = "themeBody",property = "themeBody")
//    })
//    List<Theme> selectThemeByID(Theme theme);

    /**
     *
     * @param themeID
     * @return
     */
    @Select("select * from theme where themeID = #{themeID}")
    @Results({
            @Result(id=true,column = "themeID",property = "themeID"),
            @Result(column = "visitorID",property = "visitor",one = @One(select = "Dao.VisitorMapper.selectByID")),
            @Result(column = "themeTitle",property = "themeTitle"),
            @Result(column = "themeBody",property = "themeBody"),
            @Result(column = "isBest",property = "isBest")
    })
    Theme selectThemeByID(int themeID);

    /**
     * 新增主题
     * @param theme
     */
    @Insert("insert into theme(themeID, themeTitle, visitorID, themeBody,isBest) VALUES (null,#{themeTitle},#{visitor.visitorID},#{themeBody},0)")
    void insertTheme(Theme theme);

    /**
     * 修改主题
     * @param theme
     */
    @Update("update theme set themeTitle = #{themeTitle},themeBody = #{themeBody} where themeID = #{themeID}")
    void updateTheme (Theme theme);

    /**
     * 删除主题
     * @param themeID
     */
    @Delete("delete from theme where themeID = #{themeID}")
    void deleteTheme(int themeID);

    /**
     * 设为精华
     * @param themeID
     */
    @Update("update theme set isBest = 1 where themeID = #{themeID}")
    void isBestTheme(int themeID);

    /**
     * 取消精华
     * @param themeID
     */
    @Update("update theme set isBest = 0 where themeID = #{themeID}")
    void notBestTheme(int themeID);
}
