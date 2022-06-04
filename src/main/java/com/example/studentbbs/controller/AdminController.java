package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.service.AdminService;

import org.springframework.stereotype.Controller;
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

    @GetMapping({ "", "/", "/index" })
    public String index(HttpSession session) {
        return "admin/index";
    }

    @GetMapping({ "/login" })
    public String login() {
        return "admin/login";
    }

    @PostMapping({ "/login" })
    @ResponseBody
    public String login(@RequestParam("username") String userName, @RequestParam("password") String password,
            HttpSession session) {
        return "admin/login";
    }
}
