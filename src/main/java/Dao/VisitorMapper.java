package Dao;

import org.apache.ibatis.annotations.*;
import pojo.Visitor;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-24 22:34
 * @desc
 */
public interface VisitorMapper {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from visitor")
     List<Visitor> selectAll();

    /**
     * 通过姓名找用户
     * @param visitorName
     * @return
     */
    @Select("select * from visitor where visitorName = #{visitorName}")
    Visitor selectByName(String visitorName);

    /**
     * 查询是否是管理员
     * @param visitorID
     * @return
     */
    @Select("select * from visitor where visitorID = #{visitorID}")
    Visitor selectIsMaster(int visitorID);

    /**
     *查找用户
     * @param visitorID
     * @return
     */
    @Select( "select * from visitor where visitorID = #{visitorID}")
     Visitor selectByID(int visitorID);
    /**
     * 多条件查询用户
     */
    List<Visitor>   selectByCondition(@Param("visitorName") String visitorName ,@Param("gender") String gender,@Param("phoneNumber") String phoneNumber,@Param("isMaster") int isMaster);

    /**
     * 删除用户
     * @param visitorID
     */
    @Delete("delete from visitor where visitorID = #{visitorID}")
    void deleteByID(int visitorID);

    /**
     * 注册
     * @param visitor
     */
    @Insert("insert into visitor(visitorID, visitorName, gender, phoneNumber, password, isMaster) VALUES (null,#{visitorName},#{gender},#{phoneNumber},#{password},0)")
    boolean add(Visitor visitor);

    /**
     * 更新自己信息
     * @param visitorName
     * @param gender
     * @param password
     * @param phoneNumber
     * @param visitorID
     */
    @Update("update visitor set visitorName = #{visitorName}, " +
            "gender = #{gender}," +
            "password = #{password}," +
            "phoneNumber = #{phoneNumber} where visitorID = #{visitorID}")
    void update (@Param("visitorName")String visitorName,
                 @Param("gender")String gender,
                 @Param("password")String password,
                 @Param("phoneNumber")String phoneNumber,
                 @Param("visitorID")int visitorID);
    /**
     * 登录功能
     * @param visitorName
     * @param password
     * @return  用户
     */
    @Select("select * from visitor where visitorName = #{visitorName} and password = #{password}")
    Visitor login(@Param("visitorName") String visitorName,@Param("password") String password);


    /**
     *
     * @param visitorName
     * @param visitorID
     */
    @Update("update visitor set visitorName = #{visitorName} where visitorID = #{visitorID}")
    void updateByVisitorName (@Param("visitorName")String visitorName,@Param("visitorID")int visitorID);

    /**
     *
     * @param gender
     * @param visitorID
     */
    @Update("update visitor set gender = #{gender} where visitorID = #{visitorID}")
    void updateByGender (@Param("gender")String gender,@Param("visitorID")int visitorID);

    /**
     *
     * @param password
     * @param visitorID
     */
    @Update("update visitor set password = #{password} where visitorID = #{visitorID}")
    void updateByPassword (@Param("password")String password,@Param("visitorID")int visitorID);

    /**
     *
     * @param phoneNumber
     * @param visitorID
     */
    @Update("update visitor set phoneNumber = #{phoneNumber} where visitorID = #{visitorID}")
    void updateByPhoneNumber (@Param("phoneNumber")String phoneNumber,@Param("visitorID")int visitorID);

    /**
     * 修改管理员权限
     * @param isMaster
     * @param visitorID
     */
    @Update("update visitor set isMaster = #{isMaster} where visitorID = #{visitorID}")
    void updateByIsMaster (@Param("isMaster")int isMaster,@Param("visitorID")int visitorID);

}
