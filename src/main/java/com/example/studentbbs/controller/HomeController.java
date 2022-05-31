package com.example.studentbbs.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.Category;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.service.CategoryService;
import com.example.studentbbs.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleService articleService;

    @Resource
    private UserService userService;

    @GetMapping({ "", "/", "/index", "/index.html" })
    public String index(HttpSession session) {
        ArrayList<Category> categorys = new ArrayList<>();
        ArrayList<Article> articlesByLike = new ArrayList<>();
        ArrayList<Article> articlesByTime = new ArrayList<>();
        HashMap<Integer, User> users = userService.getAllUser();

        categorys = categoryService.getAllCategory();
        articlesByLike = articleService.getAllArticleByLikes();
        articlesByTime = articleService.getAllArticleByTime();
        users = userService.getAllUser();

        session.setAttribute("categorys", categorys);
        session.setAttribute("articlesByLike", articlesByLike);
        session.setAttribute("articlesByTime", articlesByTime);
        session.setAttribute("users", users);
        return "index";
    }
}
