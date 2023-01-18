package Controller;

import Service.ThemeService;
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
 * @create 2022-04-28 0:31
 * @desc
 */
@WebServlet("/addThemeServlet")
public class AddThemeServlet extends HttpServlet {

    private ThemeService themeService = new ThemeService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收数据
        String themeTitle = request.getParameter("themeTitle");
        String themeBody = request.getParameter("themeBody");
        HttpSession session = request.getSession();
        Visitor visitor = (Visitor)session.getAttribute("visitor");

        //新建对象，存入数据
        Theme theme = new Theme();
        theme.setThemeTitle(themeTitle);
        theme.setVisitor(visitor);
        theme.setThemeBody(themeBody);
        //添加数据
        themeService.add(theme);
        List<Theme> themeList = themeService.selectAll();
        //存入request域中


        session.setAttribute("themeList",themeList);

        //转发到主页
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
