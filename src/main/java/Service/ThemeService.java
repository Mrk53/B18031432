package Service;

import Dao.ThemeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Theme;
import util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-26 20:12
 * @desc
 */
public class ThemeService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查找所有
     * @return
     */
    public List<Theme> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ThemeMapper themeMapper = sqlSession.getMapper(ThemeMapper.class);
        List<Theme> themes = themeMapper.selectAllTheme();
        sqlSession.close();
        return themes;
    }

    /**
     * 发布主题
     * @param theme
     */
    public void add(Theme theme){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ThemeMapper themeMapper = sqlSession.getMapper(ThemeMapper.class);
        themeMapper.insertTheme(theme);
        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 查找主题
     * @param themeID
     * @return
     */
    public Theme selectByID(int themeID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ThemeMapper themeMapper = sqlSession.getMapper(ThemeMapper.class);
        Theme theme = themeMapper.selectThemeByID(themeID);
        sqlSession.close();
        return theme;
    }

    /**
     * 删除主题
     * @param themeID
     */
    public void deleteTheme(int themeID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ThemeMapper themeMapper = sqlSession.getMapper(ThemeMapper.class);
        themeMapper.deleteTheme(themeID);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 修改主题
     * @param theme
     */
    public void updateTheme(Theme theme){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ThemeMapper themeMapper = sqlSession.getMapper(ThemeMapper.class);
        themeMapper.updateTheme(theme);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 修改精华主题
     * @param themeID
     * @param best
     */
    public void bestTheme(int themeID,int best){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ThemeMapper themeMapper = sqlSession.getMapper(ThemeMapper.class);
        if (best == 1){
            themeMapper.isBestTheme(themeID);
        }else {
            themeMapper.notBestTheme(themeID);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
