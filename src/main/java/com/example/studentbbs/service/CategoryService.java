package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.entity.Category;

public interface CategoryService {
    
    ArrayList<Category> getAllCategory();

    Integer updateCateStatusToFreeze(Integer valueOf);

    Integer updateCateStatusToNormal(Integer valueOf);

    Integer updateCateInfo(Integer idList, String cateName, Integer cateRank);

    Integer addCate(Category category);

    Integer deleteCateById(Integer valueOf);
}
