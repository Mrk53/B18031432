package Controller;

import Service.ActivityService;
import Service.VisitorActivityService;
import pojo.Activity;
import pojo.VisitorActivity;

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
 * @create 2022-04-30 3:45
 * @desc
 */
@WebServlet("/activityServlet")
public class ActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VisitorActivityService visitorActivityService = new VisitorActivityService();
        //接收数据
        int activityID = Integer.parseInt(request.getParameter("activityID"));
        //查找所有用户
        List<VisitorActivity> visitorActivities = visitorActivityService.selectAllByActivityID(activityID);
        //处理无人情况
        if (visitorActivities.size() == 0){
            VisitorActivity visitorActivity = new VisitorActivity();
            visitorActivity.setVisitor(null);

            //手动查找统战信息
            ActivityService activityService = new ActivityService();
            Activity activity = activityService.selectByID(activityID);
            visitorActivity.setActivity(activity);
            visitorActivities.add(visitorActivity);
        }
        //存入session域中
        HttpSession session = request.getSession();
        session.setAttribute("activityID",activityID);
        session.setAttribute("visitorActivities",visitorActivities);
        //转发到详情页面
        request.getRequestDispatcher("activity.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
