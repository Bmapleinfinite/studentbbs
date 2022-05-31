package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.common.ServiceResultEnum;
import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public Result articlePub(
            @RequestParam("title") String title, @RequestParam("content") String content,
            @RequestParam("categoryID") String categoryID, @RequestParam("verifyCode") String verifyCode,
            @RequestParam("categoryName") String categoryName, HttpSession session) {


        if (!StringUtils.hasLength(title)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_TITLE.getResult());
        }
        if (!StringUtils.hasLength(content)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_CONTENT.getResult());
        }
        if (!StringUtils.hasLength(categoryName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_CATEGORY.getResult());
        }
        if (!StringUtils.hasLength(verifyCode)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_VERIFYCODE.getResult());
        }
        String captcha = (String) session.getAttribute("VerifyCode");
        if (!verifyCode.equals(captcha)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.WRONG_VERIFYCODE.getResult());
        }
        
        Article article = new Article();
        User user = (User) session.getAttribute("user");
        article.setUserId(user.getId());
        article.setTitle(title);
        article.setContent(content);
        article.setCategoryID(Integer.parseInt(categoryID));
        article.setCategoryName(categoryName);

        int result = articleService.articlePub(article);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult();
        }
    }
}
