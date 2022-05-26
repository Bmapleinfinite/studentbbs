package com.example.studentbbs.controller;

import com.wf.captcha.GifCaptcha;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaptchaController {
    @GetMapping("/common/captcha")
    public void defaultCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expries", 0L);
        response.setContentType("image/gif");
        GifCaptcha captcha = new GifCaptcha(75, 30, 4);
        captcha.setCharType(1);
        request.getSession().setAttribute("VerifyCode", captcha.text().toLowerCase());
        captcha.out((OutputStream) response.getOutputStream());
    }
}
