package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.entity.Admin;
import com.example.studentbbs.service.AdminService;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({ "/admin" })
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping({ "/login" })
    public String login() {
        return "index";
    }

    @GetMapping({ "", "/", "/index" })
    public String index(HttpSession session) {
        return "admin/index";
    }

    @PostMapping({ "/login" })
    public String login(@RequestParam("username") String userName, @RequestParam("password") String password,
            HttpSession session) {
        if (!StringUtils.hasText(userName)) {
            session.setAttribute("errormsg", "用户名不能为空");
            return "index";
        }
        if (!StringUtils.hasText(password)) {
            session.setAttribute("errormsg", "密码不能为空");
            return "index";
        }
        Admin admin = adminService.login(userName, password);
        if (admin != null) {
            session.setAttribute("loginUser", admin.getAdminNickName());
            session.setAttribute("loginUserID", admin.getAdminId());
            return "admin/index";
        }
        session.setAttribute("errormsg", "登录失败");
        return "index";
    }
}
