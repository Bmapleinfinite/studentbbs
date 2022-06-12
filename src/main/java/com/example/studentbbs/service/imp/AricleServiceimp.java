package com.example.studentbbs.service.imp;

import java.util.ArrayList;
import java.util.Map;

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

    @Override
    public ArrayList<Article> getAllArticleByTime() {
        return articleDao.getAllArticleByTime();
    }

    @Override
    public ArrayList<Article> getAllArticleByLikes() {
        return articleDao.getAllArticleByLikes();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleDao.getArticleById(id);
    }

	@Override
    public ArrayList<Article> getAllArticleByParams(String orderby, String categoryId, String keyword) {
		return articleDao.getAllArticleByParams(orderby, categoryId, keyword);
	}

    @Override
    public ArrayList<Article> getArticleByUserId(Integer userId) {
        return articleDao.getArticleByUserId(userId);
    }

    @Override
    public Map<Integer, Article> getAllArticleByMap() {
        return articleDao.getAllArticleByMap();
    }

    @Override
    public Integer updateArticleStatusToNormal(Integer id) {
        return articleDao.updateArticleStatusToNormal(id);
    }

    @Override
    public Integer updateArticleStatusToFreeze(Integer id) {
        return articleDao.updateArticleStatusToFreeze(id);
    }

    @Override
    public Integer deleteArticleById(Integer id) {
        return articleDao.deleteArticleById(id);
    }

    @Override
    public Integer updateArticleById(String articleId, String title, String content, String categoryID,
            String categoryName) {
        return articleDao.updateArticleById(articleId, title, content, categoryID, categoryName);
    }

    @Override
    public Integer updateArticleViewById(Integer id, Integer size, Integer likes, Integer collects) {
        return articleDao.updateArticleViewById(id, size, likes, collects);
    }
}
