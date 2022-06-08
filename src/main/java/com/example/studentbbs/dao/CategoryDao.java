package com.example.studentbbs.dao;

import java.util.ArrayList;

import com.example.studentbbs.entity.Category;

import org.springframework.stereotype.Component;

@Component
public interface CategoryDao {
    ArrayList<Category> getAllCategory();

    Integer updateCateStatusToFreeze(Integer cateId);

    Integer updateCateStatusToNormal(Integer cateId);

    Integer updateCateInfo(Integer cateId, String cateName, Integer cateRank);

    Integer addCate(Category category);

    Integer deleteCateById(Integer cateId);
}
