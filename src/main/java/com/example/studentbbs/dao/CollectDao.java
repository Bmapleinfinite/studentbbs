/**
 * 收藏数据访问对象
 */
package com.example.studentbbs.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.studentbbs.entity.Record;

@Component
public interface CollectDao {

    Integer addCollect(Record record);

    Integer removeCollect(Record record);

    Integer getCollectRecordByArticleId(Integer id);

    Record getCollectRecordBy2Id(int id, int id2);

    ArrayList<Record> getAllCollectRecordByUserId(int id);
    
}
