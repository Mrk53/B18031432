package Controller;

import Service.DiscussService;
import Service.IsLikeService;
import Service.ThemeService;
import Service.VisitorService;
import pojo.Discuss;
import pojo.IsLike;
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
 * @create 2022-04-28 3:21
 * @desc    跳转主题
 */
@WebServlet("/discussServlet")
public class DiscussServlet extends HttpServlet {
    private DiscussService discussService = new DiscussService();
    private ThemeService themeService = new ThemeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String discussion = request.getParameter("discuss");
        if (null == discussion){
            //准备页面数据
            int themeID= Integer.parseInt(request.getParameter("themeID"));
            List<Discuss> discusses = discussService.selectAllByThemeID(themeID);
            Theme theme = themeService.selectByID(themeID);
            HttpSession session = request.getSession();
            Visitor visitor = (Visitor)session.getAttribute("visitor");
            IsLikeService isLikeService = new IsLikeService();
            List<IsLike> isLikesList = isLikeService.selectByVisitorID(visitor.getVisitorID());
            session.setAttribute("isLikesList",isLikesList);
            session.setAttribute("discusses",discusses);
            session.setAttribute("themeID",themeID);
            session.setAttribute("theme",theme);
            //转发到对应的页面
        }else {
            String name = request.getParameter("name");

            //发表评论
            if (name.equals("发评论")){
                Discuss discuss = new Discuss();
                discuss.setDiscussion(discussion);
                HttpSession session = request.getSession();
                discuss.setTheme((Theme) session.getAttribute("theme"));
                discuss.setVisitor((Visitor) session.getAttribute("visitor"));
                discussService.addDiscuss(discuss);
            }else if ("点赞".equals(name)){
            //     点赞
                IsLikeService isLikeService = new IsLikeService();
                //获取自己ID
                HttpSession session = request.getSession();
                Visitor visitor= (Visitor)session.getAttribute("visitor");
                Integer visitorID = visitor.getVisitorID();
                //获取评论ID
                int discussID = Integer.parseInt(discussion);
                //看是点赞还是取消
                String like = request.getParameter("isLike");
                System.out.println(like);
                if ("true".equals(like)){
                    //点赞
                    isLikeService.like(discussID,visitorID);
                }else if ("false".equals(like)){
                    //取消点赞
                    isLikeService.dislike(discussID,visitorID);
                }
            }
        }

        request.getRequestDispatcher("/discuss.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
