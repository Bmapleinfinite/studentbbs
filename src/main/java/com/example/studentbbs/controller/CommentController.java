package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.Comment;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.CommentService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {
    
    @Resource
    private CommentService commentService;

    @PostMapping("/commentPub")
    @ResponseBody
    public Result commentPub(@RequestParam("commentBody") String commentBody, HttpSession session) {
        Article article = new Article();
        User user = new User();
        article = (Article) session.getAttribute("article");
        user = (User) session.getAttribute("user");

        Comment comment = new Comment();
        comment.setCommentBody(commentBody);
        comment.setPostId(article.getId());
        comment.setUserId(user.getId());

        int result = commentService.commentPub(comment);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }
}
