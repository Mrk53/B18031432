package Controller;

import Service.ThemeService;
import Service.VisitorService;
import pojo.Theme;
import pojo.Visitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-25 2:58
 * @desc
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {


    private VisitorService visitorService = new VisitorService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        request.setCharacterEncoding("UTF-8");

        //接收数据
        String name = (request.getParameter("name")) ;
        String value = request.getParameter("value");
        int visitorID = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Visitor visitor =    (Visitor)session.getAttribute("visitor");
        int visitorIDofMine = visitor.getVisitorID();

        if ("删除用户".equals(name)){
            //删除语句
            visitorService.delete(visitorID);
        }else{
            //修改语句
            visitorService.update(name,value,visitorID);
        }

        //修改

        Visitor visitor1 = visitorService.selectByID(visitorIDofMine);
        //完成查询
        ThemeService themeService = new ThemeService();
        List<Theme> themeList = themeService.selectAll();
        VisitorService visitorService = new VisitorService();
        List<Visitor> visitors = visitorService.selectAll();


        //将登陆成功后的用户对象存到Session中

        session.setAttribute("visitors",visitors);
        session.setAttribute("themeList",themeList);
        session.setAttribute("visitor",visitor1);



        //转发到查询所有
        request.getRequestDispatcher("/visitor.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
