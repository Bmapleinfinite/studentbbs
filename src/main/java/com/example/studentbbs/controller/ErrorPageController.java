/**
 * 错误页面控制层
 */
package com.example.studentbbs.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {
    /**
     * 错误页面跳转操作
     * @param request
     * @return
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode.intValue() == HttpStatus.NOT_FOUND.value())
                return "error/error_404";
            if (statusCode.intValue() == HttpStatus.INTERNAL_SERVER_ERROR.value())
                return "error/error_5xx";
        }
        return "error/error_400";
    }
}
