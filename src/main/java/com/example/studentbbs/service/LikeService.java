package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Record;

public interface LikeService {

    Integer addLike(Record record);

    Integer removeLike(Record record);

    Integer getLikeRecordByArticleId(Integer id);

    Boolean vaildUserLikeRecord(Integer id, Integer id2);

    ArrayList<Record> getAllLikeRecordByUserId(int id);
    
}
