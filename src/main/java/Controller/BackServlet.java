package Controller;

import Service.ActivityService;
import Service.ThemeService;
import Service.VisitorService;
import pojo.Activity;
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
 * @create 2022-05-03 2:03
 * @desc
 */
@WebServlet("/backServlet")
public class BackServlet extends HttpServlet {
    private VisitorService visitorService = new VisitorService();
    private ThemeService themeService = new ThemeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        VisitorService visitorService = new VisitorService();
        List<Visitor> visitors = visitorService.selectAll();
        //查询统战活动
        ActivityService activityService = new ActivityService();
        List<Activity> activities = activityService.selectAll();


        List<Theme> themeList = themeService.selectAll();

        String visitor = request.getParameter("visitor");
        System.out.println(visitor);

        //存到Session中
        HttpSession session = request.getSession();
        session.setAttribute("activities",activities);
//        session.setAttribute("visitor",visitor);
        session.setAttribute("visitors",visitors);
        session.setAttribute("themeList",themeList);

        //跳转到首页
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
