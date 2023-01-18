package com.B18031432;

import Dao.VisitorMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Visitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-24 23:01
 * @desc
 */
public class test {
    @Test
    public void testSelectAll() throws IOException {

        String phoneNumber = "6970";
        //模糊处理
        phoneNumber="%"+phoneNumber+"%";


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
        //执行方法
        List<Visitor> visitors = visitorMapper.selectAll();
        System.out.println(visitors);


        Visitor visitor = visitorMapper.selectByID(4);
        System.out.println(visitor);

        List<Visitor> visitors1 = visitorMapper.selectByCondition("", "", phoneNumber, 0);
        System.out.println(visitors1);

//        Visitor visitor2    = new Visitor(11,"心悦","女","15198675214","7854",0);
//        visitorMapper.add(visitor2);
//        //提交事务
//        sqlSession.commit();

        List<Visitor> visitor1 = visitorMapper.selectByCondition("","女","",0);
        System.out.println(visitor1);

        sqlSession.close();
    }

    @Test
    public void  AppendToFileTest(){
        String content = "A cat will append to the end of the file";
        try{
            File file =new File("testAppendFile.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            //使用true，即进行append file
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            fileWritter.write(content);
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("finish");

    }

}
