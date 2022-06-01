package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Article;

public interface ArticleService {
    Integer articlePub(Article article);

    ArrayList<Article> getAllArticleByTime();

    ArrayList<Article> getAllArticleByLikes();

    Article getArticleById(Integer id);
}
