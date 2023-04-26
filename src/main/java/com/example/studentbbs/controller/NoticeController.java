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

    /**
     * 发送系统通知
     * @param sysNoticeName 通知名
     * @param sysNoticeContent 通知内容
     * @return
     */
    @PostMapping("/addSysNotice")
    @ResponseBody
    public Result addSysNotice(
            @RequestParam("sysNoticeName") String sysNoticeName,
            @RequestParam("sysNoticeContent") String sysNoticeContent) {
        Notice notice = new Notice();

        ArrayList<User> allUser = userService.getAllUser();
        /* -1 为管理员发送 */
        notice.setFromUserId(-1);
        notice.setNoticeContent(sysNoticeContent);
        notice.setNoticeName(sysNoticeName);
        /* 将通知设置为系统通知 */
        notice.setNoticeType(NoticeTypeEnum.NOTICE_TYPE_SYSTEM.getType());
        /* 通过stream流 向所有用户发送通知 */
        allUser.forEach((x) -> {
            notice.setToUserId(x.getId());
            noticeService.addNotice(notice);
        });

        return ResultGenerator.genSuccessResult();
    }
}
