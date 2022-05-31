package com.example.studentbbs.dao;

import java.util.ArrayList;

import com.example.studentbbs.entity.Category;

import org.springframework.stereotype.Component;

@Component
public interface CategoryDao {
    ArrayList<Category> getAllCategory();
}
