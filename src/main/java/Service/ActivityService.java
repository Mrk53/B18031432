package Service;

import Dao.ActivityMapper;
import Dao.VisitorMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Activity;
import pojo.Visitor;
import util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-29 3:32
 * @desc
 */
public class ActivityService {
    public List<Activity> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper ActivityMapper = sqlSession.getMapper(ActivityMapper.class);
        List<Activity> activities = ActivityMapper.selectAllActivity();
        sqlSession.close();
        return activities;
    }


    /**
     * 手动查找统战信息
     * @return
     */
    public Activity selectByID(int activityID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper ActivityMapper = sqlSession.getMapper(ActivityMapper.class);
        Activity activity = ActivityMapper.selectByID(activityID);
        sqlSession.close();
        return activity;
    }

    /**
     * 修改统战信息
     * @param activity
     */
    public void updateActivity(Activity activity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper ActivityMapper = sqlSession.getMapper(ActivityMapper.class);
        ActivityMapper.update(
                activity.getActivityTitle(),
                activity.getMoney(),
                activity.getActivityBody(),
                activity.getActivityID());
        sqlSession.commit();    //提交改变信息；
        sqlSession.close();     //关闭连接
    }

    /**
     * 改变统战体
     * @param activityBody
     * @param activityID
     */
    //获取数据库连接
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void updateActivityBody(String activityBody,int activityID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper ActivityMapper = sqlSession.getMapper(ActivityMapper.class);
        ActivityMapper.updateActivityBody(activityBody,activityID);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除统战信息
     * @param activityID
     * @return
     */
    public void  deleteByID(int activityID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper ActivityMapper = sqlSession.getMapper(ActivityMapper.class);
        ActivityMapper.deleteByID(activityID);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 增加统战信息
     * @param activity
     */

    public void add (Activity activity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
        activityMapper.add(activity);
        sqlSession.commit();
        sqlSession.close();
    }


}
