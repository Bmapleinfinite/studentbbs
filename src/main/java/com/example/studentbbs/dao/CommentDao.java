package com.example.studentbbs.dao;

import java.util.ArrayList;

import com.example.studentbbs.entity.Comment;

import org.springframework.stereotype.Component;

@Component
public interface CommentDao {
    Integer commentPub(Comment comment);

    ArrayList<Comment> getCommentsByArticleId(Integer id);

    ArrayList<Comment> getCommentsByUserId(Integer userId);

    ArrayList<Comment> getAllComments();

    Integer updateCommentStatusToNormal(Integer id);

    Integer updateCommentStatusToFreeze(Integer id);

    Integer deleteCommentById(Integer id);

    String getCommentBodyById(Integer id);
}
