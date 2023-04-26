/**
 * 系统网站配置类
 */
package com.example.studentbbs.config;

import com.example.studentbbs.common.SystemVarEnum;
import com.example.studentbbs.interceptor.AdminLoginInterceptor;
import com.example.studentbbs.interceptor.UserInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSiteConfigurer implements WebMvcConfigurer {

    /* 获取上传文件存放路径 */
    private final static String FILE_UPLOAD_DIC = SystemVarEnum.FILE_UPLOAD_DIC.getValue();

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    @Autowired
    private UserInterceptor userInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        /* 后台拦截器  */
        registry.addInterceptor((HandlerInterceptor) adminLoginInterceptor)
                .addPathPatterns("/admin/**").excludePathPatterns("/admin/login");
        /* 用户拦截器  */    
        registry.addInterceptor((HandlerInterceptor) userInterceptor)
                .addPathPatterns("/user/**").excludePathPatterns("/user/login", "/user/register");
        /* 文章拦截器  */
        registry.addInterceptor((HandlerInterceptor) userInterceptor)
                .addPathPatterns("/article/**");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 将 /upload/** 路径下的所有文件 映射到上传文件存放的路径下 */
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + FILE_UPLOAD_DIC);
    }
}
