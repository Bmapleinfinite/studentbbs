package com.example.studentbbs.controller;

import com.example.studentbbs.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbBbsNotice)表控制层
 *
 * @author makejava
 * @since 2023-03-19 18:29:00
 */
@RestController
@RequestMapping("tbBbsNotice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService tbBbsNoticeService;


}

