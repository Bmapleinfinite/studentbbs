package com.example.studentbbs.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.common.ServiceResultEnum;
import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.Comment;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.service.CommentService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    @GetMapping("/detail/{id}")
    public String detailById(@PathVariable Integer id, HttpSession session) {
        Article article = new Article();
        ArrayList<Comment> comments = new ArrayList<>();
        article = articleService.getArticleById(id);
        comments = commentService.getCommentsByArticleId(id);
        session.setAttribute("article", article);
        session.setAttribute("comments", comments);
        return "article/detail";
    }

    @GetMapping("/articlePub")
    public String articlePub(HttpSession session) {
        return "article/articlePub";
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
        } else {
            return ResultGenerator.genFailResult();
        }
    }

    @GetMapping("/articleEdit/{id}")
    public String articleEdit(@PathVariable Integer id, HttpServletRequest request) {
        Article article = new Article();
        article = articleService.getArticleById(id);

        request.setAttribute("article", article);
        return "article/articleEdit";
    }

    @PostMapping("/articleEdit")
    @ResponseBody
    public Result articleEdit(
            @RequestParam("articleId") String articleId,
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

        int result = articleService.updateArticleById(articleId, title, content, categoryID, categoryName);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }
    
    @PostMapping("/unFreezeArticle")
    @ResponseBody
    public Result unFreezeArticle(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = articleService.updateArticleStatusToNormal(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分帖子审核失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }
    
    @PostMapping("/freezeArticle")
    @ResponseBody
    public Result freezeArticle(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = articleService.updateArticleStatusToFreeze(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分帖子取消审核失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/deleteArticle")
    @ResponseBody
    public Result deleteArticle(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for(String elem : userId_arr){
            Integer result = articleService.deleteArticleById(Integer.valueOf(elem));
            if(result < 0){
                return ResultGenerator.genFailResult("部分帖子删除失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }
}
