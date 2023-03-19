package com.example.studentbbs.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.studentbbs.dao.CollectDao;
import com.example.studentbbs.entity.Record;
import com.example.studentbbs.service.CollectService;


@Service
public class CollectServiceimpl implements CollectService {

    @Resource
    private CollectDao collectDao;

    @Override
    public Integer addCollect(Record record) {
        return collectDao.addCollect(record);
    }

    @Override
    public Integer removeCollect(Record record) {
        return collectDao.removeCollect(record);
    }

    @Override
    public Integer getCollectRecordByArticleId(Integer id) {
        return collectDao.getCollectRecordByArticleId(id);
    }

    @Override
    public Boolean vaildUserCollectRecord(int id, int id2) {
        Record record = collectDao.getCollectRecordBy2Id(id, id2);
        if (record == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ArrayList<Record> getAllCollectRecordByUserId(int id) {
        return collectDao.getAllCollectRecordByUserId(id);
    }
    
}
