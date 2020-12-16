package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo06 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo06执行了...");

        chain.doFilter(req, resp);

        System.out.println("filterDemo06回来了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
