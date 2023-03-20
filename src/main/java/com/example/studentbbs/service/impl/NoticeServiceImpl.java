package com.example.studentbbs.service.impl;

import com.example.studentbbs.dao.NoticeDao;
import com.example.studentbbs.entity.Notice;
import com.example.studentbbs.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import javax.annotation.Resource;

/**
 * (TbBbsNotice)表服务实现类
 *
 * @author makejava
 * @since 2023-03-19 18:29:00
 */
@Service("tbBbsNoticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    @Override
    public Boolean isNewNoticeForUserByUserId(int id) {
        Integer count = noticeDao.isNewNoticeForUserByUserId(id);
        return count > 0;
    }

    @Override
    public ArrayList<Notice> getAllnoticeByUserId(int id, int msgType) {
        ArrayList<Notice> result = noticeDao.getAllnoticeByUserId(id, msgType);
        return result;
    }

    @Override
    public Boolean updateAllNoticeByUserId(int id, Integer msgType) {
        Boolean result = noticeDao.updateAllNoticeByUserId(id, msgType);
        return result;
    }

    @Override
    public Integer addNotice(Notice notice) {
        return noticeDao.addNotice(notice);
    }
}
