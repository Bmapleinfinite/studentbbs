package com.example.studentbbs.service;

import java.util.ArrayList;
import java.util.Map;

import com.example.studentbbs.entity.Article;

public interface ArticleService {
    /**
     * 发布文章
     * 
     * @param article 文章对象
     * @return
     */
    Integer articlePub(Article article);

    /**
     * 根据时间获取所有文章
     * @return
     */
    ArrayList<Article> getAllArticleByTime();

    /**
     * 根据点赞数获取所有文章
     * @return
     */
    ArrayList<Article> getAllArticleByLikes();

    /**
     * 根据文章ID获取文章
     * @return
     */
    Article getArticleById(Integer id);

    /**
     * 根据参数获取所有文章
     * @return
     */
    ArrayList<Article> getAllArticleByParams(String orderby, String categoryId, String keyword);

    /**
     * 根据用户ID获取所有文章
     * @return
     */
    ArrayList<Article> getArticleByUserId(Integer userId);

    /**
     * 以ID为Key值，获取所有文章
     * @return
     */
    Map<Integer, Article> getAllArticleByMap();

    /**
     * 根据ID解冻文章
     * @param valueOf 文章ID
     * @return
     */
    Integer updateArticleStatusToNormal(Integer valueOf);

    /**
     * 根据ID冻结文章
     * @param valueOf 文章ID
     * @return
     */
    Integer updateArticleStatusToFreeze(Integer valueOf);

    /**
     * 删除文章
     * 
     * @param valueOf 文章ID
     * @return
     */
    Integer deleteArticleById(Integer valueOf);

    /**
     * 修改文章
     * 
     * @param articleId 文章id
     * @param title 文章标题
     * @param content 文章内容
     * @param categoryID 文章所在分类ID
     * @param categoryName 分类名称
     * @return
     */
    Integer updateArticleById(String articleId, String title, String content, String categoryID,
            String categoryName);

    /**
     * 更新文章阅读量
     * 
     * @param id 文章id
     * @param size 评论个数
     * @param likes 点赞数
     * @param collects 收藏数
     * @return
     */
    Integer updateArticleViewById(Integer id, Integer size, Integer likes, Integer collects);
}
