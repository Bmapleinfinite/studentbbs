package com.example.studentbbs.service.imp;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.studentbbs.dao.CategoryDao;
import com.example.studentbbs.entity.Category;
import com.example.studentbbs.service.CategoryService;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceimp implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public ArrayList<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
    
}
