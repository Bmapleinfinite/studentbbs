/**
 * 点赞控制层
 */
package com.example.studentbbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studentbbs.entity.Record;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.LikeService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

@Controller
public class LikeController {
    
    @Resource
    private LikeService likeService;

    /**
     * 添加点赞操作
     * @param id 文章id
     * @param session
     * @return
     */
    @PostMapping("/addLike/{id}")
    @ResponseBody
    public Result addLike(@PathVariable Integer id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Record record = new Record();
        record.setPostId(id);
        record.setUserId(user.getId());
        int result = likeService.addLike(record);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }

    /**
     * 移除点赞操作
     * @param id 文章id
     * @param session
     * @return
     */
    @PostMapping("/removeLike/{id}")
    @ResponseBody
    public Result removeLike(@PathVariable Integer id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Record record = new Record();
        record.setPostId(id);
        record.setUserId(user.getId());
        int result = likeService.removeLike(record);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }
}
