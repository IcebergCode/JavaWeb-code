package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 重定向
* */
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1.............");

        //访问/responseDemo01会自动跳转到/responseDemo02资源

/*
        //完成重定向方法1：
        //1. 设置状态码302
        response.setStatus(302);
        //2. 设置响应头location
        response.setHeader("location", "/day12/responseDemo02");
*/

        request.setAttribute("msg", "response");

        //动态获取虚拟目录（推荐）
        String contextPath = request.getContextPath();

        //完成重定向方法2：
        //简单的重定向方法
        response.sendRedirect(contextPath + "/responseDemo02");
        //response.sendRedirect("http://wwww.itcast.cn");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
