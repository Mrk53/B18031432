package Controller;

import Service.ActivityService;
import pojo.Activity;
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
 * @create 2022-05-01 0:44
 * @desc
 */
@WebServlet("/addActivityServlet")
public class AddActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        request.setCharacterEncoding("UTF-8");

        //接收数据
        String activityTitle = request.getParameter("activityTitle");
        String activityBody = request.getParameter("activityBody");
        int money = Integer.parseInt(request.getParameter("money"));


        Activity activity = new Activity();
        activity.setMoney(money);
        activity.setActivityTitle(activityTitle);
        activity.setActivityBody(activityBody);

        //添加数据
        ActivityService activityService = new ActivityService();
        activityService.add(activity);
        //更新活动表
        List<Activity> activities = activityService.selectAll();
        //存到Session中
        HttpSession session = request.getSession();
        session.setAttribute("activities",activities);

        //跳转到首页
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
