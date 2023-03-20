package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.common.NoticeTypeEnum;
import com.example.studentbbs.common.ServiceResultEnum;
import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.Comment;
import com.example.studentbbs.entity.Notice;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.service.CommentService;
import com.example.studentbbs.service.NoticeService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {
    public static final String REPLY = "回复";

    @Resource
    private CommentService commentService;

    @Resource
    private ArticleService articleService;

    @Resource
    private NoticeService noticeService;

    @PostMapping("/commentPub/{id}")
    @ResponseBody
    public Result commentPub(
            @RequestParam("commentBody") String commentBody,
            @PathVariable Integer id,
            HttpSession session) {

        User user = new User();
        user = (User) session.getAttribute("user");
        if (user == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_LOGINED_USER.getResult());
        }

        Article article = new Article();
        article = articleService.getArticleById(id);

        Comment comment = new Comment();
        comment.setCommentBody(commentBody);
        comment.setPostId(article.getId());
        comment.setUserId(user.getId());

        Notice notice = new Notice();
        notice.setFromUserId(user.getId());
        notice.setToUserId(article.getUserId());
        notice.setNoticeName(REPLY);
        notice.setNoticeType(NoticeTypeEnum.NOTICE_TYPE_REPLY.getType());
        notice.setNoticeContent(commentBody);

        int result = commentService.commentPub(comment);
        if (result > 0) {
            result = noticeService.addNotice(notice);
            if (result > 0) {
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult();
            }
        } else {
            return ResultGenerator.genFailResult();
        }
    }

    @PostMapping("/unFreezeComment")
    @ResponseBody
    public Result unFreezeComment(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = commentService.updateCommentStatusToNormal(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分评论审核失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/freezeComment")
    @ResponseBody
    public Result freezeComment(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = commentService.updateCommentStatusToFreeze(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分评论取消审核失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/deleteComment")
    @ResponseBody
    public Result deleteComment(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = commentService.deleteCommentById(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分评论删除失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }
}
