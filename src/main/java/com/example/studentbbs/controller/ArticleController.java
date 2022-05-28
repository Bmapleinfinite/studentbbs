package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.entity.Article;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/articlePub")
    public String articlePub(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "user/login";
        } else {
            return "article/articlePub";
        }
    }

    @PostMapping("/articlePub")
    public Result articlePub(@RequestParam("userId") int userId,
            @RequestParam("title") String title, @RequestParam("content") String content,
            @RequestParam("categoryID") int categoryID, @RequestParam("categoryName") String categoryName) {

        Article article = new Article();
        article.setUserId(userId);
        article.setTitle(title);
        article.setContent(content);
        article.setCategoryID(categoryID);
        article.setCategoryName(categoryName);

        int result = articleService.articlePub(article);
        
        return ResultGenerator.genSuccessResult();
    }
}
