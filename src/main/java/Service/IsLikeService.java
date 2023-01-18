package Service;

import Dao.DiscussMapper;
import Dao.IsLikeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Discuss;
import pojo.IsLike;
import util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-05-07 9:37
 * @desc
 */
public class IsLikeService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 通过点赞者查找所有点赞
     * @param visitorID
     * @return
     */
    public List<IsLike> selectByVisitorID(int visitorID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IsLikeMapper isLikeMapper = sqlSession.getMapper(IsLikeMapper.class);
        List<IsLike> isLikes = isLikeMapper.selectIsLikeByVisitor(visitorID);
        sqlSession.close();
        return isLikes;
    }

    /**
     * 点赞功能
     * @param discussID
     * @param visitorID
     */
    public void like(int discussID,int visitorID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IsLikeMapper isLikeMapper = sqlSession.getMapper(IsLikeMapper.class);
        isLikeMapper.like(visitorID,discussID);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 取消点赞功能
     * @param discussID
     * @param visitorID
     */
    public void dislike(int discussID,int visitorID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IsLikeMapper isLikeMapper = sqlSession.getMapper(IsLikeMapper.class);
        isLikeMapper.dislike(visitorID,discussID);
        sqlSession.commit();
        sqlSession.close();
    }
}
