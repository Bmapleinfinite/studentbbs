
/**
 * 通知服务类
 */
package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Notice;

public interface NoticeService {

    Boolean isNewNoticeForUserByUserId(int id);

    ArrayList<Notice> getAllnoticeByUserId(int id, int msgType);

    Boolean updateAllNoticeByUserId(int id, Integer msgType);

    Integer addNotice(Notice notice);
}
