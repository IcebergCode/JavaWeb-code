package cn.itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//@WebServlet(urlPatterns = "/demo")    /*设置urlPatterns为"/demo"，也可以设置为"/demo1"、"/demo2"、"/demo3"...，无影响*/
//@WebServlet(value = "/demo")          /*设置value为"/demo"，也可以设置为"/demo1"、"/demo2"、"/demo3"...，无影响*/
@WebServlet("/demo")                    /*设置为"/demo"，也可以设置为"/demo1"、"/demo2"、"/demo3"...，无影响*/
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet3.0来了.........");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
