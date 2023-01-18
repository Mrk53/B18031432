package Controller;

import Service.ActivityService;
import Service.ThemeService;
import Service.VisitorService;
import pojo.Activity;
import pojo.Theme;
import pojo.Visitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * @autor Mrk
 * @create 2022-04-25 2:11
 * @desc
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private VisitorService visitorService = new VisitorService();
    private ThemeService themeService = new ThemeService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //接收用户名和密码
        String visitorName = request.getParameter("visitorName");
        String password = request.getParameter("password");
        //获取记住我
        String remember = request.getParameter("remember");

        //判断登录
        Visitor visitor = visitorService.login(visitorName, password);


        if (visitor != null){
            //判断是否勾选记住我
            if ("1".equals(remember)){
                //创建cookie
                Cookie cookieName = new Cookie("visitorName", visitorName);
                Cookie cookiePassword = new Cookie("password", password);
                //设置存活时间
                cookieName.setMaxAge(60 * 60 * 24);
                cookiePassword.setMaxAge(60 * 60  * 24);
                //发送cookie
                response.addCookie(cookieName);
                response.addCookie(cookiePassword);
            }

            //查询主题和用户之间的UI硬关系
            List<Theme> themeList = themeService.selectAll();
            //存入request域中



            //查询所有用户
            VisitorService visitorService = new VisitorService();
            List<Visitor> visitors = visitorService.selectAll();
            //查询统战活动
            ActivityService activityService = new ActivityService();
            List<Activity> activities = activityService.selectAll();



            //存到Session中
            HttpSession session = request.getSession();
            session.setAttribute("activities",activities);
            session.setAttribute("visitor",visitor);
            session.setAttribute("visitors",visitors);
            session.setAttribute("themeList",themeList);

            //跳转到首页
            request.getRequestDispatcher("/index.jsp").forward(request,response);

        }else {
            //登陆失败
            //存储错误信息到request中
                request.setAttribute("login_message","用户名或密码错误");

            //跳转到login.jsp
                request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
