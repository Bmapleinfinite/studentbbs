package com.example.studentbbs.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {
  @RequestMapping("/error")
  public String handleError(HttpServletRequest request) {
    Object status = request.getAttribute("javax.servlet.error.status_code");
    if (status != null) {
      Integer statusCode = Integer.valueOf(status.toString());
      if (statusCode.intValue() == HttpStatus.NOT_FOUND.value())
        return "error/error_404"; 
      if (statusCode.intValue() == HttpStatus.INTERNAL_SERVER_ERROR.value())
        return "error/error_500"; 
    } 
    return "error/error_400";
  }
}
