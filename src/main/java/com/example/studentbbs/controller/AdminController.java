/**
 * 管理员控制层
 */
package com.example.studentbbs.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.common.ServiceResultEnum;
import com.example.studentbbs.dto.CommonDataDto;
import com.example.studentbbs.entity.Admin;
import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.Category;
import com.example.studentbbs.entity.Comment;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.AdminService;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.service.CategoryService;
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
@RequestMapping({ "/admin" })
public class AdminController {
    
    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    @Resource
    private HomeController homeController;


    /**
     * 跳转到仪表盘页面
     * @return 页面路径
     */
    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    /**
     * 获取性别分布图表数据
     * @return JSON数据格式
     */
    @PostMapping("/getSexualFBGragh")
    @ResponseBody
    public Result getSexualFBGragh() {
        ArrayList<CommonDataDto> result = userService.getSexualFBData();
        return ResultGenerator.genSuccessResult(result);
    }

    /**
     * 获取阅读量图表数据
     * @return JSON数据格式
     */
    @PostMapping("/getReadRankGragh")
    @ResponseBody
    public Result getReadRankGragh() {
        ArrayList<CommonDataDto> result = articleService.getReadRankData();
        Collections.reverse(result);
        return ResultGenerator.genSuccessResult(result);
    }

    /**
     * 获取文章分类分布图表数据
     * @return JSON数据格式
     */
    @PostMapping("/cateFBGragh")
    @ResponseBody
    public Result getCateFBGragh(){
        ArrayList<CommonDataDto> result = categoryService.getCateFBData();
        result.forEach((x)->{
            x.setName(x.getName() + " : " + x.getValue());
        });
        return ResultGenerator.genSuccessResult(result);
    }

    /**
     * 获取活跃人数图表数据
     * @return JSON数据格式
     */
    @PostMapping("/loginNumGragh")
    @ResponseBody
    public Result getLoginNumDto(){
        ArrayList<Integer> loginNums = userService.getLoginNum();
        return ResultGenerator.genSuccessResult(loginNums);
    }
    /**
     * 进入管理员主页面
     * @param session
     * @return
     */
    @GetMapping({ "", "/", "/index", "/index.html" })
    public String index(HttpSession session) {
        return "admin/index";
    }

    /**
     * 跳转到管理员登录页面
     * @return
     */
    @GetMapping({ "/login" })
    public String login() {
        return "admin/login";
    }

    /**
     * 管理员登录操作
     * 
     * @param loginName 管理员登录名
     * @param password 密码
     * @param verifyCode 验证码
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
        Admin admin = adminService.login(loginName, password);
        if (admin == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_USER.getResult());
        } else {
            session.setAttribute("admin", admin);
            session.removeAttribute("errormsg");
            return ResultGenerator.genSuccessResult();
        }
    }

    /**
     * 用户管理页面
     * @param session
     * @param request
     * @param page 当前页 默认为 1
     * @return
     */
    @GetMapping("/userManage")
    public String userManage(HttpSession session, HttpServletRequest request,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ArrayList<User> users = new ArrayList<>();
        users = userService.getAllUser();

        request.setAttribute("users", users);
        request.setAttribute("size", users.size());
        request.setAttribute("page", page);
        return "admin/userManage";
    }
    
    /**
     * 分类管理页面
     * @param session
     * @param request
     * @param page 当前页 默认为 1
     * @return
     */
    @GetMapping("/categoryManage")
    public String categoryManage(HttpSession session, HttpServletRequest request,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ArrayList<Category> categories = new ArrayList<>();
        categories = categoryService.getAllCategory();

        request.setAttribute("categories", categories);
        request.setAttribute("size", categories.size());
        request.setAttribute("page", page);
        return "admin/categoryManage";
    }

    /**
     * 文章管理页面
     * @param session
     * @param request
     * @param page 当前页 默认为 1
     * @return
     */
    @GetMapping("/articleManage")
    public String articleManage(HttpSession session, HttpServletRequest request,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ArrayList<Article> articles = new ArrayList<>();
        Map<Integer, User> users = new HashMap<>();
        articles = articleService.getAllArticleByTime();
        users = userService.getAllUserByMap();

        request.setAttribute("articles", articles);
        request.setAttribute("users", users);
        request.setAttribute("size", articles.size());
        request.setAttribute("page", page);
        return "admin/articleManage";
    }

    /**
     * 评论管理页面
     * @param session
     * @param request
     * @param page 当前页 默认为 1
     * @return
     */
    @GetMapping("/commentManage")
    public String commentManage(HttpSession session, HttpServletRequest request,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ArrayList<Comment> comments = new ArrayList<>();
        Map<Integer, Article> articlesMap = new HashMap<>();
        Map<Integer, User> users = new HashMap<>();

        articlesMap = articleService.getAllArticleByMap();
        users = userService.getAllUserByMap();
        comments = commentService.getAllComments();

        request.setAttribute("articlesMap", articlesMap);
        request.setAttribute("users", users);
        request.setAttribute("comments", comments);
        request.setAttribute("size", comments.size());
        request.setAttribute("page", page);
        return "admin/commentManage";
    }

    /**
     * 管理员注销
     * @param session
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        session.removeAttribute("admin");
        return homeController.index(session, request, 1, "time", "", "");
    }
}
