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

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleService articleService;

    @Resource
    private UserService userService;

    @GetMapping({ "", "/", "/index", "/index.html" })
    public String index(HttpSession session, HttpServletRequest request,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "orderby", required = false, defaultValue = "time") String orderby,
                        @RequestParam(value = "categoryId", required = false) String categoryId,
                        @RequestParam(value = "keyword", required = false) String keyword) {
        ArrayList<Category> categorys = new ArrayList<>();
        ArrayList<Article> articlesList = new ArrayList<>();
        HashMap<Integer, User> users = userService.getAllUserByMap();

        categorys = categoryService.getAllCategory();
        articlesList = articleService.getAllArticleByParams(orderby, categoryId, keyword);
        users = userService.getAllUserByMap();

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
