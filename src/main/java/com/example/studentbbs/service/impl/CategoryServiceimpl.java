package com.example.studentbbs.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.studentbbs.dao.CategoryDao;
import com.example.studentbbs.entity.Category;
import com.example.studentbbs.service.CategoryService;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceimpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public ArrayList<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    public Integer updateCateStatusToFreeze(Integer cateId) {
        return categoryDao.updateCateStatusToFreeze(cateId);
    }

    @Override
    public Integer updateCateStatusToNormal(Integer cateId) {
        return categoryDao.updateCateStatusToNormal(cateId);
    }

    @Override
    public Integer updateCateInfo(Integer cateId, String cateName, Integer cateRank) {
        return categoryDao.updateCateInfo(cateId, cateName, cateRank);
    }

    @Override
    public Integer addCate(Category category) {
        return categoryDao.addCate(category);
    }

    @Override
    public Integer deleteCateById(Integer cateId) {
        return categoryDao.deleteCateById(cateId);
    }
    
}
