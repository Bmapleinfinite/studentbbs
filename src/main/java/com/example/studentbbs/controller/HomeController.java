package com.example.studentbbs.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.Category;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.service.CategoryService;
import com.example.studentbbs.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    /**
     * 文章分类 Service
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 文章 Service
     */
    @Resource
    private ArticleService articleService;

    /**
     * 用户 Service
     */
    @Resource
    private UserService userService;

    /**
     * 打开网站进入首页
     * 
     * @param session
     * @param request
     * @param page 当前页数 默认为 1
     * @param orderby 排序依据 默认为 time 以时间排序
     * @param categoryId  分类ID
     * @param keyword 查找关键字
     * @return
     */
    @GetMapping({ "", "/", "/index", "/index.html" })
    public String index(HttpSession session, HttpServletRequest request,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "orderby", required = false, defaultValue = "time") String orderby,
                        @RequestParam(value = "categoryId", required = false) String categoryId,
                        @RequestParam(value = "keyword", required = false) String keyword) {
        // 变量定义
        ArrayList<Category> categorys = new ArrayList<>();
        ArrayList<Article> articlesList = new ArrayList<>();
        HashMap<Integer, User> users = new HashMap<>();

        // 获取所有分类
        categorys = categoryService.getAllCategory();
        // 通过参数获取文章
        articlesList = articleService.getAllArticleByParams(orderby, categoryId, keyword);
        // 根据用户ID进行分组
        users = userService.getAllUserByMap();

        // 定义前端数据
        request.setAttribute("categorys", categorys);
        request.setAttribute("users", users);
        request.setAttribute("articlesList", articlesList);
        request.setAttribute("page", page);
        request.setAttribute("orderby", orderby);
        request.setAttribute("size", articlesList.size());
        request.setAttribute("categoryId", categoryId);
        request.setAttribute("keyword", keyword);
        return "index";
    }
}
