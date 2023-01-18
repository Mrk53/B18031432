package Controller;

import Service.DiscussService;
import Service.IsLikeService;
import pojo.Discuss;
import pojo.IsLike;
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
 * @create 2022-05-07 9:41
 * @desc
 */
@WebServlet("/mineServlet")
public class MineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Visitor visitor = (Visitor)session.getAttribute("visitor");

        //查看点赞过的评论
        IsLikeService isLikeService = new IsLikeService();
        List<IsLike> isLikesList = isLikeService.selectByVisitorID(visitor.getVisitorID());

        //查看发表的评论
        DiscussService discussService = new DiscussService();
        List<Discuss> discussesOfMine = discussService.selectAllByVisitorID(visitor.getVisitorID());

        session.setAttribute("isLikesList",isLikesList);
        session.setAttribute("discussesOfMine",discussesOfMine);


        //转发
        request.getRequestDispatcher("/mine.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
