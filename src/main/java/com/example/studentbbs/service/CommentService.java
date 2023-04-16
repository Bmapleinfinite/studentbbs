package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Comment;

public interface CommentService {
    /**
     * 发布评论
     * @param comment 评论对象
     * @return
     */
    Integer commentPub(Comment comment);

    /**
     * 根据文章ID获取评论
     * @param id 文章ID
     * @return
     */
    ArrayList<Comment> getCommentsByArticleId(Integer id);

    /**
     * 通过用户ID获取文章
     * @param userId 用户ID
     * @return
     */
    ArrayList<Comment> getCommentsByUserId(Integer userId);

    /**
     * 获取所有评论
     * @return
     */
    ArrayList<Comment> getAllComments();

    /**
     * 解冻评论
     * @param id 评论ID
     * @return
     */
    Integer updateCommentStatusToNormal(Integer id);

    /**
     * 冻结评论
     * @param id 评论ID
     * @return
     */
    Integer updateCommentStatusToFreeze(Integer id);

    /**
     * 删除评论
     * @param id 评论ID
     * @return
     */
    Integer deleteCommentById(Integer id);

    /**
     * 根据ID获取评论内容
     * @param id
     * @return
     */
    String getCommentBodyById(Integer id);
}
