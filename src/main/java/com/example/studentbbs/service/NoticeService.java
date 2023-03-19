package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Notice;

/**
 * (TbBbsNotice)表服务接口
 *
 * @author makejava
 * @since 2023-03-19 18:29:00
 */
public interface NoticeService {

    Boolean isNewNoticeForUserByUserId(int id);

    ArrayList<Notice> getAllnoticeByUserId(int id, int msgType);

    Boolean updateAllNoticeByUserId(int id, Integer msgType);
}
