/**
 * 通知数据访问对象
 */
package com.example.studentbbs.dao;

import java.util.ArrayList;

import com.example.studentbbs.entity.Notice;

/**
 * (TbBbsNotice)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-19 18:29:00
 */
public interface NoticeDao {

    Integer isNewNoticeForUserByUserId(int id);

    ArrayList<Notice> getAllnoticeByUserId(int id, int msgType);

    Boolean updateAllNoticeByUserId(int id, Integer msgType);

    Integer addNotice(Notice notice);
}

