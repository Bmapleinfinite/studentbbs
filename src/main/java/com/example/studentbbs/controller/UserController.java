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
import com.example.studentbbs.entity.Record;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.service.CollectService;
import com.example.studentbbs.service.CommentService;
import com.example.studentbbs.service.LikeService;
import com.example.studentbbs.service.UserService;
import com.example.studentbbs.util.MD5Util;
import com.example.studentbbs.util.PatternUtil;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private HomeController homController;

    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    @Resource
    private UserService userService;

    @Resource
    private LikeService likeService;

    @Resource
    private CollectService collectService;

    /**
     * 用户设定页面
     * @return
     */
    @GetMapping("/userSetting")
    public String userSetting() {
        return "user/userSetting";
    }

    /**
     * 更新用户信息操作
     * @param userId
     * @param nickName
     * @param gender
     * @param location
     * @param introduce
     * @param session
     * @return
     */
    @PostMapping("/userInfoUpdate")
    @ResponseBody
    public Result userInfoUpdate(
            @RequestParam("userId") Integer userId,
            @RequestParam("nickName") String nickName,
            @RequestParam("gender") String gender,
            @RequestParam("location") String location,
            @RequestParam("introduce") String introduce, HttpSession session) {

        if (!StringUtils.hasLength(nickName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_NICKNAME.getResult());
        }
        if (!StringUtils.hasLength(gender)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_GENDER.getResult());
        }
        if (!StringUtils.hasLength(location)) {
            location = ServiceResultEnum.DEFAULT_UNKNOW.getResult();
        }
        if (!StringUtils.hasLength(introduce)) {
            introduce = ServiceResultEnum.DEFAULT_INTRODUCE.getResult();
        }
        int result = userService.updateUserInfoById(userId, nickName, gender, location, introduce);
        if (result > 0) {
            User user = userService.getUserById(userId);
            session.setAttribute("user", user);
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }

    /**
     * 更新用户头像操作
     * @param userId
     * @param headImg
     * @param session
     * @return
     */
    @PostMapping("/headImgUpdate")
    @ResponseBody
    public Result headImgUpdate(
        @RequestParam("userId") Integer userId,
        @RequestParam("headImg") String headImg, HttpSession session) {

        if (!StringUtils.hasLength(headImg)) {
            return ResultGenerator.genFailResult("userHeadImg参数错误");
        }

        int result = userService.headImgUpdateById(headImg, userId);
        if (result > 0) {
            User user = userService.getUserById(userId);
            session.setAttribute("user", user);
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }
    
    /**
     * 更新用户密码
     * @param userId
     * @param nowPass
     * @param newPass
     * @param verifyCode
     * @param session
     * @return
     */
    @PostMapping("/updateUserPass")
    @ResponseBody
    public Result updateUserPass(
            @RequestParam("userId") Integer userId,
            @RequestParam("nowPass") String nowPass,
            @RequestParam("newPass") String newPass,
            @RequestParam("verifyCode") String verifyCode, HttpSession session) {

        User user = (User) session.getAttribute("user");
        
        if (nowPass.equals(newPass)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.SAME_PASS.getResult());
        }

        String passwordMD5 = MD5Util.MD5Encode(user.getLoginName() + nowPass, "UTF-8");
        if (!user.getPassword().equals(passwordMD5)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.WRONG_NOW_PASSWORD.getResult());
        }

        String captcha = (String) session.getAttribute("VerifyCode");
        if (!verifyCode.equals(captcha)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.WRONG_VERIFYCODE.getResult());
        }

        passwordMD5 = MD5Util.MD5Encode(user.getLoginName() + newPass, "UTF-8");
        int result = userService.updateUserPass(userId, passwordMD5);
        if (result > 0) {
            session.removeAttribute("user");
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }

    /**
     * 用户中心页面
     * @param request
     * @param session
     * @param Apage
     * @param Cpage
     * @param Lpage
     * @param Copage
     * @return
     */
    @GetMapping("/userCenter")
    public String userCenter(HttpServletRequest request, HttpSession session,
            @RequestParam(value = "Apage", required = false, defaultValue = "1") Integer Apage,
            @RequestParam(value = "Cpage", required = false, defaultValue = "1") Integer Cpage,
            @RequestParam(value = "Lpage", required = false, defaultValue = "1") Integer Lpage,
            @RequestParam(value = "Copage", required = false, defaultValue = "1") Integer Copage) {
        ArrayList<Article> articlesList = new ArrayList<>();
        ArrayList<Comment> commentsList = new ArrayList<>();
        ArrayList<Record> likeRecords = new ArrayList<>();
        ArrayList<Record> collectRecords = new ArrayList<>();
        Map<Integer, Article> articlesMap = new HashMap<>();

        User user = (User) session.getAttribute("user");

        articlesList = articleService.getArticleByUserId(user.getId());
        articlesMap = articleService.getAllArticleByMap();
        commentsList = commentService.getCommentsByUserId(user.getId());
        likeRecords = likeService.getAllLikeRecordByUserId(user.getId());
        collectRecords = collectService.getAllCollectRecordByUserId(user.getId());

        request.setAttribute("articlesList", articlesList);
        request.setAttribute("articlesMap", articlesMap);
        request.setAttribute("commentsList", commentsList);
        request.setAttribute("likeRecords", likeRecords);
        request.setAttribute("collectRecords", collectRecords);
        request.setAttribute("Asize", articlesList.size());
        request.setAttribute("Csize", commentsList.size());
        request.setAttribute("Lsize", likeRecords.size());
        request.setAttribute("Cosize", collectRecords.size());

        request.setAttribute("Apage", Apage);
        request.setAttribute("Cpage", Cpage);
        request.setAttribute("Lpage", Lpage);
        request.setAttribute("Copage", Copage);

        return "user/userCenter";
    }

    /**
     * 用户登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    /**
     * 用户登录操作
     * @param loginName
     * @param password
     * @param verifyCode
     * @param session
     * @return
     */
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
        if (user == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_USER.getResult());
        }
        Integer result = userService.updateLastLoginTimeById(user.getId());
        if (result != 1) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_USER.getResult());
        } else {
            session.setAttribute("user", user);
            session.removeAttribute("errormsg");
            return ResultGenerator.genSuccessResult();
        }
    }

    /**
     * 用户注册页面
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    /**
     * 用户注册操作
     * @param loginName
     * @param password
     * @param nickName
     * @param verifyCode
     * @param session
     * @return
     */
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

    /**
     * 解冻用户操作
     * @param arr_id
     * @return
     */
    @PostMapping("/unFreezeUser")
    @ResponseBody
    public Result unFreezeUser(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for(String elem : userId_arr){
            Integer result = userService.updateUserStatusToNormal(Integer.valueOf(elem));
            if(result < 0){
                return ResultGenerator.genFailResult("部分用户解冻失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 冻结用户操作
     * @param arr_id
     * @return
     */
    @PostMapping("/freezeUser")
    @ResponseBody
    public Result usersDelete(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for(String elem : userId_arr){
            Integer result = userService.updateUserStatusToFreeze(Integer.valueOf(elem));
            if(result < 0){
                return ResultGenerator.genFailResult("部分用户解冻失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除用户操作
     * @param arr_id
     * @return
     */
    @PostMapping("/deleteUser")
    @ResponseBody
    public Result deleteUser(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for(String elem : userId_arr){
            Integer result = userService.deleteUserById(Integer.valueOf(elem));
            if(result < 0){
                return ResultGenerator.genFailResult("部分用户删除失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 用户注销
     * @param session
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        session.removeAttribute("user");
        return homController.index(session, request, 1, "time", "", "");
    }
}
