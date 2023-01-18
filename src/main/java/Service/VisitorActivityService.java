package Service;

import Dao.ActivityMapper;
import Dao.VisitorActivityMapper;
import Dao.VisitorMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Activity;
import pojo.VisitorActivity;
import util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-29 3:36
 * @desc
 */
public class VisitorActivityService {
    /**
     * 通过活动ID查找用户
     */
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<VisitorActivity> selectAllByActivityID(int activityID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorActivityMapper visitorActivityMapper = sqlSession.getMapper(VisitorActivityMapper.class);
        List<VisitorActivity> visitorActivities = visitorActivityMapper.selectAllByActivityID(activityID);
        sqlSession.close();
        return visitorActivities;
    }

    /**
     * 删除活动用户
     * @param visitorID
     * @param activityID
     */
    public void deleteVisitorOfActivity (int visitorID, int activityID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorActivityMapper visitorActivityMapper = sqlSession.getMapper(VisitorActivityMapper.class);
        visitorActivityMapper.deleteVisitorOfActivity(activityID,visitorID);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 添加活动用户
     * @param visitorID
     * @param activityID
     */
    public void addVisitorToActivity (int visitorID, int activityID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorActivityMapper visitorActivityMapper = sqlSession.getMapper(VisitorActivityMapper.class);
        visitorActivityMapper.addVisitorToActivity(activityID,visitorID);
        sqlSession.commit();
        sqlSession.close();
    }

}
