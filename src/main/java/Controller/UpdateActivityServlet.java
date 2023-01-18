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
 * @create 2022-04-30 4:50
 * @desc
 */
@WebServlet("/updateActivityServlet")
public class UpdateActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        int activityID = (int)session.getAttribute("activityID");

        String name = request.getParameter("name");
        //判断操作类型
        if ( null == name){
            String activityTitle = request.getParameter("activityTitle");
            String activityBody = request.getParameter("activityBody");
            int money = Integer.parseInt(request.getParameter("money"));

            //修改
            Activity activity = new Activity();
            activity.setActivityBody(activityBody);
            activity.setActivityTitle(activityTitle);
            activity.setMoney(money);
            activity.setActivityID(activityID);

            ActivityService activityService = new ActivityService();
            activityService.updateActivity(activity);


        }else if("增加或减少统战人员".equals(name)){
            String value = request.getParameter("value");
            int visitorID = Integer.parseInt(request.getParameter("id"));

            VisitorActivityService visitorActivityService = new VisitorActivityService();
            if ("true".equals(value)){
                //添加成员
                visitorActivityService.addVisitorToActivity(visitorID,activityID);
            }else {
                //减少成员
                visitorActivityService.deleteVisitorOfActivity(visitorID,activityID);
            }

        } else if("改变统战信息".equals(name)) {
            String value = request.getParameter("value");
            ActivityService activityService = new ActivityService();
            activityService.updateActivityBody(value,activityID);

        }else if("删除统战活动".equals(name)){
            ActivityService activityService = new ActivityService();
            activityService.deleteByID(activityID);

            //更新活动列表
            List<Activity> activities = activityService.selectAll();
            session.setAttribute("activities",activities);

            //转发到首页
        }


        //转发回原界面
       request.getRequestDispatcher("activityServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
