package com.example.studentbbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.common.ServiceResultEnum;
import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.Comment;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.service.CommentService;
import com.example.studentbbs.service.UserService;
import com.example.studentbbs.util.PatternUtil;
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
@RequestMapping("/user")
public class UserController {
    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    @Resource
    private UserService userService;

    @GetMapping("/userSetting")
    public String userSetting() {
        return "user/userSetting";
    }

    @GetMapping("/userCenter")
    public String userCenter(HttpServletRequest request, HttpSession session, 
                            @RequestParam(value = "Apage", required = false , defaultValue = "1") Integer Apage,
                            @RequestParam(value = "Cpage", required = false , defaultValue = "1") Integer Cpage) {
        ArrayList<Article> articlesList = new ArrayList<>();
        ArrayList<Comment> commentsList = new ArrayList<>();
        Map<Integer, Article> articlesMap = new HashMap<>();

        User user = (User) session.getAttribute("user");

        articlesList = articleService.getArticleByUserId(user.getId());
        articlesMap = articleService.getAllArticle();
        commentsList = commentService.getCommentsByUserId(user.getId());

        request.setAttribute("articlesList", articlesList);
        request.setAttribute("articlesMap", articlesMap);
        request.setAttribute("commentsList", commentsList);
        request.setAttribute("Asize", articlesList.size());
        request.setAttribute("Csize", commentsList.size());

        request.setAttribute("Apage", Apage);
        request.setAttribute("Cpage", Cpage);

        return "user/userCenter";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(
            @RequestParam("loginName") String loginName,
            @RequestParam("password") String password,
            @RequestParam("verifyCode") String verifyCode,
            HttpSession session) {
        if (!StringUtils.hasLength(loginName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_LOGIN_NAME.getResult());
        }
        if (!PatternUtil.isEmail(loginName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NOT_EMAIL.getResult());
        }
        if (!StringUtils.hasLength(password)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_PASSWORD.getResult());
        }
        if (!StringUtils.hasLength(verifyCode)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_VERIFYCODE.getResult());
        }
        String captcha = (String) session.getAttribute("VerifyCode");
        if (!verifyCode.equals(captcha)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.WRONG_VERIFYCODE.getResult());
        }
        User user = userService.login(loginName, password);
        Integer result = userService.updateLastLoginTimeById(user.getId());
        if (user == null || result != 1) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_USER.getResult());
        } else {
            session.setAttribute("user", user);
            session.removeAttribute("errormsg");
            return ResultGenerator.genSuccessResult();
        }
    }

    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(
            @RequestParam("loginName") String loginName,
            @RequestParam("password") String password,
            @RequestParam("nickName") String nickName,
            @RequestParam("verifyCode") String verifyCode,
            HttpSession session) {
        if (!StringUtils.hasLength(loginName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_LOGIN_NAME.getResult());
        }
        if (!PatternUtil.isEmail(loginName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NOT_EMAIL.getResult());
        }
        if (!StringUtils.hasLength(password)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_PASSWORD.getResult());
        }
        if (!StringUtils.hasLength(verifyCode)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_VERIFYCODE.getResult());
        }
        String captcha = (String) session.getAttribute("VerifyCode");
        if (!verifyCode.equals(captcha)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.WRONG_VERIFYCODE.getResult());
        }

        User user = new User();
        user.setGender(ServiceResultEnum.DEFAULT_UNKNOW.getResult());
        user.setLocation(ServiceResultEnum.DEFAULT_UNKNOW.getResult());
        user.setHeadImgUrl(ServiceResultEnum.DEFAULT_HEADIMGURL.getResult());
        user.setIntroduce(ServiceResultEnum.DEFAULT_INTRODUCE.getResult());
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setNickName(nickName);

        Integer result = userService.register(user);
        if (result == 1) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(ServiceResultEnum.USER_EXCIT.getResult());
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "index";
    }
}
