package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Comment;

public interface CommentService {
    Integer commentPub(Comment comment);

    ArrayList<Comment> getAllComments(Integer id);

    ArrayList<Comment> getCommentsByUserId(Integer userId);
}
