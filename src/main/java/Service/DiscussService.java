package Service;

import Dao.DiscussMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Discuss;
import pojo.Theme;
import util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-28 5:47
 * @desc
 */
public class DiscussService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 通过主题查找所有评论
     * @return
     */
    public List<Discuss> selectAllByThemeID( int themeID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiscussMapper discussMapper = sqlSession.getMapper(DiscussMapper.class);
        List<Discuss> discusses = discussMapper.selectAllByThemeID(themeID);
        sqlSession.close();
        return discusses;
    }

    /**
     * 通过发评论者查找
     * @param visitorID
     * @return
     */
    public List<Discuss> selectAllByVisitorID( int visitorID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiscussMapper discussMapper = sqlSession.getMapper(DiscussMapper.class);
        List<Discuss> discusses = discussMapper.selectByVisitorID(visitorID);
        sqlSession.close();
        return discusses;
    }

    /**
     * 发布评论
     * @param discuss
     */
    public void addDiscuss(Discuss discuss){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiscussMapper discussMapper = sqlSession.getMapper(DiscussMapper.class);
        discussMapper.addDiscuss(discuss.getDiscussion(),discuss.getTheme().getThemeID(),discuss.getVisitor().getVisitorID());
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除评论
     * @param discussID
     */
    public void deleteDiscuss(int discussID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiscussMapper discussMapper = sqlSession.getMapper(DiscussMapper.class);
        discussMapper.deleteDiscuss(discussID);
        sqlSession.commit();
        sqlSession.close();
    }
}
