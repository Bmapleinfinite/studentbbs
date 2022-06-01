package com.example.studentbbs.dao;

import java.util.ArrayList;

import com.example.studentbbs.entity.Comment;

import org.springframework.stereotype.Component;

@Component
public interface CommentDao {
    Integer commentPub(Comment comment);

    ArrayList<Comment> getAllComments(Integer id);
}
