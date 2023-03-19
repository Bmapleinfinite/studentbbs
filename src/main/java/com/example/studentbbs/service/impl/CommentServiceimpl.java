package com.example.studentbbs.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.studentbbs.dao.CommentDao;
import com.example.studentbbs.entity.Comment;
import com.example.studentbbs.service.CommentService;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceimpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public Integer commentPub(Comment comment) {
        return commentDao.commentPub(comment);
    }

    @Override
    public ArrayList<Comment> getCommentsByArticleId(Integer id) {
        return commentDao.getCommentsByArticleId(id);
    }

    @Override
    public ArrayList<Comment> getCommentsByUserId(Integer userId) {
        return commentDao.getCommentsByUserId(userId);
    }

    @Override
    public ArrayList<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    @Override
    public Integer updateCommentStatusToNormal(Integer id) {
        return commentDao.updateCommentStatusToNormal(id);
    }

    @Override
    public Integer updateCommentStatusToFreeze(Integer id) {
        return commentDao.updateCommentStatusToFreeze(id);
    }

    @Override
    public Integer deleteCommentById(Integer id) {
        return commentDao.deleteCommentById(id);
    }
    
}
