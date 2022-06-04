package com.example.studentbbs.config;

import com.example.studentbbs.interceptor.AdminLoginInterceptor;
import com.example.studentbbs.interceptor.UserInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSiteConfigurer implements WebMvcConfigurer {
    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    @Autowired
    private UserInterceptor userInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) adminLoginInterceptor)
                .addPathPatterns("/admin/**").excludePathPatterns("/admin/login");

        registry.addInterceptor((HandlerInterceptor) userInterceptor)
                .addPathPatterns("/user/**").excludePathPatterns("/user/login", "/user/register");

        registry.addInterceptor((HandlerInterceptor) userInterceptor)
                .addPathPatterns("/article/**");
    }
}
