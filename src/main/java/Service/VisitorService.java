package Service;

import Dao.VisitorMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Visitor;
import util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-25 1:25
 * @desc
 */
public class VisitorService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Visitor> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
        List<Visitor> visitors = visitorMapper.selectAll();
        sqlSession.close();
        return visitors;
    }

    public boolean add (Visitor visitor){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);


        //查询是否已经存在
        Visitor visitorIsNamed = visitorMapper.selectByName(visitor.getVisitorName());

        if (visitorIsNamed == null) {
            visitorMapper.add(visitor);
            sqlSession.commit();
        }
        sqlSession.close();
        return visitorIsNamed == null;
    }

    public Visitor selectByID(int visitorID){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
        Visitor visitor = visitorMapper.selectByID(visitorID);
        sqlSession.close();
        return visitor;
    }

    public Visitor selectByName(String visitorName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
        Visitor visitor = visitorMapper.selectByName(visitorName);
        sqlSession.close();
        return visitor;
    }



    public void delete (int visitorID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
        visitorMapper.deleteByID(visitorID);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 登录方法
     * @param visitorName
     * @param password
     * @return
     */
    public Visitor login(String visitorName ,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
        Visitor visitor = visitorMapper.login(visitorName, password);
        sqlSession.close();
        return visitor;
    }
    /**
     * 修改个人信息+管理员权限
     */
    public void update(String name ,String value,int visitorID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
        if(name.equals("visitorName")){
            visitorMapper.updateByVisitorName(value,visitorID);
        }
        if(name.equals("gender")){
            visitorMapper.updateByGender(value,visitorID);
        }
        if(name.equals("phoneNumber")){
            visitorMapper.updateByPhoneNumber(value,visitorID);
        }
        if(name.equals("password")){
            visitorMapper.updateByPassword(value,visitorID);
        }
        if(name.equals("管理员权限修改")){
            Visitor visitor = visitorMapper.selectByID(visitorID);
            if (visitor.getIsMaster() == 1){
                //修改为0
                visitorMapper.updateByIsMaster(0,visitorID);
            }else {
                //修改为1
                visitorMapper.updateByIsMaster(1,visitorID);
            }
        }
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(String visitorName, String gender, String password, String phoneNumber, int visitorID){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
        visitorMapper.update(visitorName,gender,password,phoneNumber,visitorID);
        sqlSession.commit();
        sqlSession.close();
    }
}
