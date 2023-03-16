package com.example.studentbbs.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studentbbs.entity.Category;
import com.example.studentbbs.service.CategoryService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 冻结分类操作
     * @param arr_id
     * @return
     */
    @PostMapping("/freezeCate")
    @ResponseBody
    public Result freezeCate(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = categoryService.updateCateStatusToFreeze(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分分类冻结失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 解冻分类操作
     * @param arr_id
     * @return
     */
    @PostMapping("/unFreezeCate")
    @ResponseBody
    public Result unFreezeCate(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = categoryService.updateCateStatusToNormal(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分分类解冻失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新分类信息
     * @param idList
     * @param cateName
     * @param cateRank
     * @return
     */
    @PostMapping("/updateCate")
    @ResponseBody
    public Result updateCate(@RequestParam("idList") Integer idList,
            @RequestParam("cateName") String cateName,
            @RequestParam("cateRank") Integer cateRank) {
        if (idList == null) {
            ResultGenerator.genFailResult();
        }
        if (!StringUtils.hasLength(cateName)) {
            ResultGenerator.genFailResult();
        }
        if (cateRank == null) {
            ResultGenerator.genFailResult();
        }
        Integer result = categoryService.updateCateInfo(idList, cateName, cateRank);
        if(result > 0){
            return ResultGenerator.genSuccessResult();
        } else{
            return ResultGenerator.genFailResult();
        }
    }

    /**
     * 添加分类操作
     * @param cateName
     * @param cateRank
     * @return
     */
    @PostMapping("/addCate")
    @ResponseBody
    public Result addCate(@RequestParam("cateName") String cateName,
            @RequestParam("cateRank") Integer cateRank) {
        if (!StringUtils.hasLength(cateName)) {
            ResultGenerator.genFailResult();
        }
        if (cateRank == null) {
            ResultGenerator.genFailResult();
        }
        Category category = new Category();
        category.setCategoryName(cateName);
        category.setCategoryRank(cateRank);
        Integer result = categoryService.addCate(category);
        if(result > 0){
            return ResultGenerator.genSuccessResult();
        } else{
            return ResultGenerator.genFailResult();
        }
    }

    /**
     * 删除分类操作
     * @param arr_id
     * @return
     */
    @PostMapping("/deleteCate")
    @ResponseBody
    public Result deleteCate(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = categoryService.deleteCateById(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分分类删除失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }
}
