package com.example.studentbbs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURI();
        if (url.startsWith("/admin") && !url.contains("loginNumGragh") && request.getSession().getAttribute("admin") == null) {
            request.getSession().setAttribute("errormsg", "请重新登录");
            response.sendRedirect("/index");
            return false;
        }
        request.getSession().removeAttribute("errormsg");
        return true;
    }
}
