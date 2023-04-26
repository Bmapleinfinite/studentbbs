/**
 * 分类服务类
 */
package com.example.studentbbs.service;

import java.util.ArrayList;

import com.example.studentbbs.dto.CommonDataDto;
import com.example.studentbbs.entity.Category;

public interface CategoryService {
    /**
     * 获取所有分类
     * @return
     */
    ArrayList<Category> getAllCategory();

    /**
     * 冻结分类
     * @param valueOf 分类ID
     * @return
     */
    Integer updateCateStatusToFreeze(Integer valueOf);

    /**
     * 解冻分类
     * @param valueOf 分类ID
     * @return
     */
    Integer updateCateStatusToNormal(Integer valueOf);

    /**
     * 更新分类信息
     * 
     * @param idList 分类ID
     * @param cateName 分类名
     * @param cateRank 分类等级
     * @return
     */
    Integer updateCateInfo(Integer idList, String cateName, Integer cateRank);

    /**
     * 添加分类
     * @param category 分类对象
     * @return
     */
    Integer addCate(Category category);

    /**
     * 删除分类
     * @param valueOf 分类ID
     * @return
     */
    Integer deleteCateById(Integer valueOf);

    ArrayList<CommonDataDto> getCateFBData();
}
