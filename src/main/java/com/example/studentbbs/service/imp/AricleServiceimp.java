package com.example.studentbbs.service.imp;

import javax.annotation.Resource;

import com.example.studentbbs.dao.ArticleDao;
import com.example.studentbbs.entity.Article;
import com.example.studentbbs.service.ArticleService;

import org.springframework.stereotype.Service;

@Service
public class AricleServiceimp implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Override
    public Integer articlePub(Article article) {
        return articleDao.articlePub(article);
    }
}
