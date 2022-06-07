package com.example.studentbbs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserInterceptor implements HandlerInterceptor {
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURI();
        if (request.getSession().getAttribute("admin") != null) {
            return true;
        }

        if (url.startsWith("/user") && request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("errormsg", "请登录！");
            response.sendRedirect("/index");
            return false;
        }
        if (url.startsWith("/article") && request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("errormsg", "请登录！");
            response.sendRedirect("/index");
            return false;
        }
        request.getSession().removeAttribute("errormsg");
        return true;
    }
}
