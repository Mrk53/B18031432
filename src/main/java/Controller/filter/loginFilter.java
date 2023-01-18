package Controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @autor Mrk
 * @create 2022-04-26 2:41
 * @desc
 */
@WebFilter( "/*")
public class loginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //判断访问是否与登录注册相关
        HttpServletRequest request = (HttpServletRequest) req;
        //判断访问是否与登录注册相关
        //放行路径
        String[] urls ={"/loginServlet","/AddServlet","/add.jsp","/js/","/img/","/css/"};
        //获取访问路径
        String url = request.getRequestURL().toString();
        for (String u : urls) {
            if (url.contains(u)){
                chain.doFilter(req, resp);
                return;
            }
        }
        HttpSession session = request.getSession();
        Object visitor = session.getAttribute("visitor");
        if (visitor != null){
            //放行
            chain.doFilter(req, resp);
        }else {
            request.setAttribute("login_message","您没有登陆");
            request.getRequestDispatcher("/login.jsp").forward(request,resp);
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
