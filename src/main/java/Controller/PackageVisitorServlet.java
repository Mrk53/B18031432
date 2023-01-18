package Controller;

import Service.VisitorService;
import com.alibaba.fastjson.JSON;
import pojo.Visitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @autor Mrk
 * @create 2022-05-01 21:34
 * @desc
 */
@WebServlet("/packageVisitorServlet")
public class PackageVisitorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解决乱码
        request.setCharacterEncoding("UTF-8");

        //接收数据
        String name = request.getParameter("name");

        if ("打包用户信息".equals(name)){
            VisitorService visitorService = new VisitorService();
            List<Visitor> visitors = visitorService.selectAll();
            String s = JSON.toJSONString(visitors);
            System.out.println("hello");
            File file =new File("I:\\visitorsFile.txt");
            try(
                    FileWriter fileWriter = new FileWriter(file.getName(),true);){

                if(!file.exists()){
                    boolean newFile = file.createNewFile();
                    if (newFile){
                        System.out.println("创建文件");
                    }
                }
                //使用true，即进行append file
                System.out.println("添加文件");

                fileWriter.write(s);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
