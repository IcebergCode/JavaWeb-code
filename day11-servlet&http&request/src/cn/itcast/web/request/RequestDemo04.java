package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo04")
public class RequestDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据：referer
        String referer = request.getHeader("referer");
        System.out.println(referer);    //http://localhost/day11/login.html

        if(referer != null){
            if (referer.contains("day11")){
                //正常访问
                //System.out.println("播放电影");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
            }else {
                //盗链
                //System.out.println("想看电影吗？来优酷吧");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看电影吗？来优酷吧");
            }
        }
    }
}
