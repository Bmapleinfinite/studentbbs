package com.example.studentbbs.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.common.ServiceResultEnum;
import com.example.studentbbs.entity.Admin;
import com.example.studentbbs.entity.Category;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.AdminService;
import com.example.studentbbs.service.CategoryService;
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
    private HomeController homeController;

    @GetMapping({ "", "/", "/index", "/index.html" })
    public String index(HttpSession session) {
        return "admin/index";
    }

    @GetMapping({ "/login" })
    public String login() {
        return "admin/login";
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
        Admin admin = adminService.login(loginName, password);
        if (admin == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_USER.getResult());
        } else {
            session.setAttribute("admin", admin);
            session.removeAttribute("errormsg");
            return ResultGenerator.genSuccessResult();
        }
    }

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

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        session.removeAttribute("admin");
        return homeController.index(session, request, 1, "time", "", "");
    }
}
