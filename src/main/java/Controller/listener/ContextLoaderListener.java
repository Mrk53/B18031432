package Controller.listener;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @autor Mrk
 * @create 2022-04-26 2:58
 * @desc
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //销毁资源
    }
}
