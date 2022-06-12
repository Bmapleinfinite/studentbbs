package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Record;

public interface CollectService {

    Integer addCollect(Record record);

    Integer removeCollect(Record record);

    Integer getCollectRecordByArticleId(Integer id);

    Boolean vaildUserCollectRecord(int id, int id2);

    ArrayList<Record> getAllCollectRecordByUserId(int id);
    
}
