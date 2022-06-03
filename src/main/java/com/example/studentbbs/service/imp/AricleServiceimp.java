package com.example.studentbbs.service.imp;

import java.util.ArrayList;

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
}
