package com.putorn.powerdoc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录过滤器
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (isFilter(req.getRequestURI())){
            if(req.getSession().getAttribute("user") == null) {
                resp.sendRedirect("/login.html");
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isFilter(String uri) {
        if(uri.indexOf("login.html") > -1) {
            return false;
        }
        return true;
    }

}
