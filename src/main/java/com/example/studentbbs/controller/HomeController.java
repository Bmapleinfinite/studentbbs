package com.example.studentbbs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.example.studentbbs.entity.Category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "", "/", "/index", "/index.html" })
    public String index(HttpSession session) {
        ArrayList<Category> categorys = new ArrayList<>(); 
        return "index";
    }
}
