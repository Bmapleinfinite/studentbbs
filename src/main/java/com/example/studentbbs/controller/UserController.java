package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.common.ServiceResultEnum;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.UserService;
import com.example.studentbbs.util.MD5Util;
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
import org.thymeleaf.util.PatternUtils;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
            @RequestParam("verifyCode") String verifyCode, HttpSession session) {
        if (!StringUtils.hasLength(loginName)) {
            return ResultGenerator.getFailResult(ServiceResultEnum.NO_LOGIN_NAME.getResult());
        }
        if(!PatternUtil.isEmail(loginName)){
            return ResultGenerator.getFailResult(ServiceResultEnum.NOT_EMAIL.getResult());
        }
        if (!StringUtils.hasLength(password)) {
            return ResultGenerator.getFailResult(ServiceResultEnum.NO_PASSWORD.getResult());
        }
        if (!StringUtils.hasLength(verifyCode)) {
            return ResultGenerator.getFailResult(ServiceResultEnum.NO_VERIFYCODE.getResult());
        }
        String captcha = (String) session.getAttribute("VerifyCode");
        if (!verifyCode.equals(captcha)) {
            return ResultGenerator.getFailResult(ServiceResultEnum.WRONG_VERIFYCODE.getResult());
        }
        User user = userService.login(loginName, password);
        if (user == null) {
            return ResultGenerator.getFailResult(ServiceResultEnum.NO_USER.getResult());
        } else {
            session.setAttribute("user", user);
            return ResultGenerator.genSuccessResult();
        }
    }

    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
            @RequestParam("nickName") String nickName, @RequestParam("verifyCode") String verifyCode,
            HttpSession session) {
        
        String passwordMD5 = MD5Util.MD5Encode(loginName + password, "UTF-8");
        User user = new User();
        user.setGender("未知");
        user.setLocation("未知");
        user.setHeadImgUrl("/images/avatar/default.png");
        user.setIntroduce("这个人很懒，什么都没留下~");
        user.setLoginName(loginName);
        user.setPassword(passwordMD5);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "index";
    }
}
