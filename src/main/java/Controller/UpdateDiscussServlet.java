package Controller;

import Service.ActivityService;
import Service.DiscussService;
import Service.ThemeService;
import Service.VisitorActivityService;
import pojo.Activity;
import pojo.Discuss;
import pojo.Theme;

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
 * @create 2022-05-01 5:31
 * @desc
 */
@WebServlet("/updateDiscussServlet")
public class UpdateDiscussServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        ThemeService themeService = new ThemeService();
        int themeID = Integer.parseInt(request.getParameter("themeID"));
        Theme theme = themeService.selectByID(themeID);

        String name = request.getParameter("name");
        //判断操作类型
        if ( "删除评论".equals(name) ){

            int discussID = Integer.parseInt(request.getParameter("discussID"));

            DiscussService discussService = new DiscussService();

            discussService.deleteDiscuss(discussID);
            //更新评论列表
            List<Discuss> discusses = discussService.selectAllByThemeID(themeID);
            session.setAttribute("discusses",discusses);

        }else if("删除主题".equals(name)) {

            themeService.deleteTheme(themeID);
            //更新主题列表
            updateThemeList(request);

        }else if ("修改主题标题".equals(name)){

            String themeTitle = request.getParameter("value");
            Theme theme1 = new Theme();
            theme1.setThemeTitle(themeTitle);
            theme1.setThemeID(themeID);
            theme1.setThemeBody(theme.getThemeBody());

            //修改
            themeService.updateTheme(theme1);
            //更新主题列表
            updateThemeList(request);

        }else if ("修改主题详细信息".equals(name)){

            String themeBody = request.getParameter("value");
            Theme theme1 = new Theme();
            theme1.setThemeBody(themeBody);
            theme1.setThemeID(themeID);
            theme1.setThemeTitle(theme.getThemeTitle());

            //修改
            themeService.updateTheme(theme1);
            //更新主题列表
            updateThemeList(request);
        }else if ("修改为精华".equals(name)){
            themeService.bestTheme(themeID,1);
            updateThemeList(request);
        }else if ("取消精华".equals(name)){
            themeService.bestTheme(themeID,0);
            updateThemeList(request);
        }
    }

    //更新主题列表
    private void updateThemeList(HttpServletRequest request){
        ThemeService themeService = new ThemeService();
        HttpSession session = request.getSession();
        List<Theme> themeList = themeService.selectAll();
        session.setAttribute("themeList",themeList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
