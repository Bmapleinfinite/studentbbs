/**
 * 收藏服务类
 */
package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Record;

public interface CollectService {

    /**
     * 添加收藏
     * @param record 收藏表对象
     * @return
     */
    Integer addCollect(Record record);

    /**
     * 移除收藏
     * @param record 收藏表对象
     * @return
     */
    Integer removeCollect(Record record);

    /**
     * 根据文章ID获取收藏数
     * @param id 文章id
     * @return
     */
    Integer getCollectRecordByArticleId(Integer id);

    /**
     * 判断文章是否被用户收藏
     * @param id 文章id
     * @param id2 用户id
     * @return
     */
    Boolean vaildUserCollectRecord(int id, int id2);

    /**
     * 根据用户id 获取所有收藏
     * @param id 用户id
     * @return
     */
    ArrayList<Record> getAllCollectRecordByUserId(int id);
    
}
