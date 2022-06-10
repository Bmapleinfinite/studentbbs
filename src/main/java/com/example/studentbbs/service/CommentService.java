package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Comment;

public interface CommentService {
    Integer commentPub(Comment comment);

    ArrayList<Comment> getCommentsByArticleId(Integer id);

    ArrayList<Comment> getCommentsByUserId(Integer userId);

    ArrayList<Comment> getAllComments();

    Integer updateCommentStatusToNormal(Integer id);

    Integer updateCommentStatusToFreeze(Integer id);

    Integer deleteCommentById(Integer id);
}
