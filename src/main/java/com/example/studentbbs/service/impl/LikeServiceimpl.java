package com.example.studentbbs.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.studentbbs.dao.LikeDao;
import com.example.studentbbs.entity.Record;
import com.example.studentbbs.service.LikeService;

@Service
public class LikeServiceimpl implements LikeService {

    @Resource
    private LikeDao likeDao;

    @Override
    public Integer addLike(Record record) {
        return likeDao.addLike(record);
    }

    @Override
    public Integer removeLike(Record record) {
        return likeDao.removeLike(record);
    }

    @Override
    public Integer getLikeRecordByArticleId(Integer id) {
        return likeDao.getLikeRecordByArticleId(id);
    }

    @Override
    public Boolean vaildUserLikeRecord(Integer id, Integer id2) {
        Record record = likeDao.getLikeRecordBy2Id(id, id2);
        if (record == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ArrayList<Record> getAllLikeRecordByUserId(int id) {
        return likeDao.getAllLikeRecordByUserId(id);
    }
    
}
