package com.example.studentbbs.controller;

import com.example.studentbbs.common.NoticeTypeEnum;
import com.example.studentbbs.entity.Notice;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.NoticeService;
import com.example.studentbbs.service.UserService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import javax.annotation.Resource;

/**
 * (TbBbsNotice)表控制层
 *
 * @author makejava
 * @since 2023-03-19 18:29:00
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    @Resource
    private UserService userService;

    @PostMapping("/addSysNotice")
    @ResponseBody
    public Result addSysNotice(
            @RequestParam("sysNoticeName") String sysNoticeName,
            @RequestParam("sysNoticeContent") String sysNoticeContent) {
        Notice notice = new Notice();

        ArrayList<User> allUser = userService.getAllUser();
        notice.setFromUserId(-1);
        notice.setNoticeContent(sysNoticeContent);
        notice.setNoticeName(sysNoticeName);
        notice.setNoticeType(NoticeTypeEnum.NOTICE_TYPE_SYSTEM.getType());
        allUser.forEach((x) -> {
            notice.setToUserId(x.getId());
            noticeService.addNotice(notice);
        });

        return ResultGenerator.genSuccessResult();
    }
}
