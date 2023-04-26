/**
 * 点赞服务类
 */
package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Record;

public interface LikeService {

    /**
     * 添加点赞
     * @param record 
     * @return
     */
    Integer addLike(Record record);

    /**
     * 移除点赞
     * @param record 
     * @return
     */
    Integer removeLike(Record record);

    /**
     * 根据文章ID获取点赞数
     * @param id
     * @return
     */
    Integer getLikeRecordByArticleId(Integer id);

    /**
     * 判断用户是否点赞
     * @param id 文章id
     * @param id2 用户id
     * @return
     */
    Boolean vaildUserLikeRecord(Integer id, Integer id2);

    /**
     * 根据用户ID获取点赞数
     * @param id 用户id
     * @return
     */
    ArrayList<Record> getAllLikeRecordByUserId(int id);
    
}
