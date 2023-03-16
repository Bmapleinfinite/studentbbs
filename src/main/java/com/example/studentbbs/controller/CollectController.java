package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studentbbs.entity.Record;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.CollectService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

@Controller
public class CollectController {
    
    @Resource
    private CollectService collectService;

    /**
     * 添加收藏操作
     * @param id
     * @param session
     * @return
     */
    @PostMapping("/addCollect/{id}")
    @ResponseBody
    public Result addCollect(@PathVariable Integer id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Record record = new Record();
        record.setPostId(id);
        record.setUserId(user.getId());
        int result = collectService.addCollect(record);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }

    /**
     * 删除收藏操作
     * @param id
     * @param session
     * @return
     */
    @PostMapping("/removeCollect/{id}")
    @ResponseBody
    public Result removeCollect(@PathVariable Integer id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Record record = new Record();
        record.setPostId(id);
        record.setUserId(user.getId());
        int result = collectService.removeCollect(record);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }
}
