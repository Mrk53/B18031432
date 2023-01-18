package Controller;

import Service.VisitorService;
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
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {


    private VisitorService service = new VisitorService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        request.setCharacterEncoding("UTF-8");

        //接收数据
        String visitorName = request.getParameter("visitorName");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phoneNumber");

        Visitor visitor = new Visitor();
        visitor.setVisitorName(visitorName);
        visitor.setPassword(password);
        visitor.setGender(gender);
        visitor.setPhoneNumber(phoneNumber);

        //注册
        boolean flag = service.add(visitor);
        HttpSession session = request.getSession();

        if (session.getAttribute("visitor") == null){
            if (flag){
                //注册成功
                request.setAttribute("login_message","注册成功，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                //注册失败
                request.setAttribute("add_message","用户名已经存在");
                request.getRequestDispatcher("/add.jsp").forward(request,response);
            }
        }else{
            VisitorService visitorService = new VisitorService();
            List<Visitor> visitors = visitorService.selectAll();

            //将登陆成功后的用户对象存到Session中
            session.setAttribute("visitors",visitors);
            request.getRequestDispatcher("/visitor.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
