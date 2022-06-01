package com.example.studentbbs.service.imp;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.studentbbs.dao.CommentDao;
import com.example.studentbbs.entity.Comment;
import com.example.studentbbs.service.CommentService;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceimp implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public Integer commentPub(Comment comment) {
        return commentDao.commentPub(comment);
    }

    @Override
    public ArrayList<Comment> getAllComments(Integer id) {
        return commentDao.getAllComments(id);
    }
    
}
