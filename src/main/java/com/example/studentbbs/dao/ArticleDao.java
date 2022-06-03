package com.example.studentbbs.dao;

import java.util.ArrayList;

import com.example.studentbbs.entity.Article;

import org.springframework.stereotype.Component;

@Component
public interface ArticleDao {
    Integer articlePub(Article article);

    ArrayList<Article> getAllArticleByTime();

    ArrayList<Article> getAllArticleByLikes();

    Article getArticleById(Integer id);

    ArrayList<Article> getAllArticleByParams(String orderby, String categoryId, String keyword);
}