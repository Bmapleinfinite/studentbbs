/**
 * 验证码控制层
 */
package com.example.studentbbs.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;

import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaptchaController {
    /**
     * 生成验证码图片
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/common/captcha")
    public void defaultCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /* 设置请求头为输出图片类型 */
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expries", 0L);
        response.setContentType("image/gif");
        /* 设置生成的验证码图片的宽度 高度 字符个数 */
        GifCaptcha captcha = new GifCaptcha(75, 30, 4);
        /* 设置类型，纯数字、纯字母、字母数字混合 */
        captcha.setCharType(Captcha.TYPE_DEFAULT);
        /* 验证码存入session */
        request.getSession().setAttribute("VerifyCode", captcha.text().toLowerCase());
        /* 输出图片流 */
        captcha.out((OutputStream) response.getOutputStream());
    }
}
