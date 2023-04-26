/**
 * 帖子数据访问对象
 */
package com.example.studentbbs.dao;

import java.util.ArrayList;
import java.util.Map;

import com.example.studentbbs.dto.CommonDataDto;
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
    Map<Integer, Article> getAllArticleByMap();

    Integer updateArticleStatusToNormal(Integer id);

    Integer updateArticleStatusToFreeze(Integer id);

    Integer deleteArticleById(Integer id);

    Integer updateArticleById(String articleId, String title, String content, String categoryID, String categoryName);

    Integer updateArticleViewById(Integer id, Integer size, Integer likes, Integer collects);

    Integer deleteCommentByPostId(Integer id);

    ArrayList<CommonDataDto> getReadRankData();

    String getArticleContentById(String id);
}