package com.example.studentbbs.service;

import java.util.ArrayList;
import java.util.Map;

import com.example.studentbbs.entity.Article;

public interface ArticleService {
    Integer articlePub(Article article);

    ArrayList<Article> getAllArticleByTime();

    ArrayList<Article> getAllArticleByLikes();

    Article getArticleById(Integer id);

    ArrayList<Article> getAllArticleByParams(String orderby, String categoryId, String keyword);

    ArrayList<Article> getArticleByUserId(Integer userId);

    Map<Integer, Article> getAllArticleByMap();

    Integer updateArticleStatusToNormal(Integer valueOf);

    Integer updateArticleStatusToFreeze(Integer valueOf);

    Integer deleteArticleById(Integer valueOf);

    Integer updateArticleById(String articleId, String title, String content, String categoryID,
            String categoryName);
}
