package com.example.studentbbs.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.studentbbs.entity.Record;

@Component
public interface LikeDao {

    Integer addLike(Record record);

    Integer removeLike(Record record);

    Integer getLikeRecordByArticleId(Integer id);

    Record getLikeRecordBy2Id(Integer id, Integer id2);

    ArrayList<Record> getAllLikeRecordByUserId(int id);
}
