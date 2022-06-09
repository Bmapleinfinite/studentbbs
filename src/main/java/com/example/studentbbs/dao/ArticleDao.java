package com.example.studentbbs.dao;

import java.util.ArrayList;
import java.util.Map;

import com.example.studentbbs.entity.Article;

import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Component;

@Component
public interface ArticleDao {
    Integer articlePub(Article article);

    ArrayList<Article> getAllArticleByTime();

    ArrayList<Article> getAllArticleByLikes();

    Article getArticleById(Integer id);

    ArrayList<Article> getAllArticleByParams(String orderby, String categoryId, String keyword);

    ArrayList<Article> getArticleByUserId(Integer userId);

    @MapKey("id")
    Map<Integer, Article> getAllArticle();

    Integer updateArticleStatusToNormal(Integer id);

    Integer updateArticleStatusToFreeze(Integer id);

    Integer deleteArticleById(Integer id);
}