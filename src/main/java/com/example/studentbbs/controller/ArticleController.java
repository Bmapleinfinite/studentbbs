/**
 * 文章控制层
 */
package com.example.studentbbs.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.studentbbs.common.ServiceResultEnum;
import com.example.studentbbs.entity.Article;
import com.example.studentbbs.entity.Category;
import com.example.studentbbs.entity.Comment;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.ArticleService;
import com.example.studentbbs.service.CategoryService;
import com.example.studentbbs.service.CollectService;
import com.example.studentbbs.service.CommentService;
import com.example.studentbbs.service.LikeService;
import com.example.studentbbs.service.UserService;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleService articleService;

    @Resource
    private UserService userService;

    @Resource
    private CommentService commentService;

    @Resource
    private CollectService collectService;

    @Resource
    private LikeService likeService;

    /**
     * 通过id访问某个文章
     * 
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/detail/{id}")
    public String detailById(@PathVariable Integer id, HttpServletRequest request) {
        Article article = new Article();
        // 判断用户是否登录 若未登录 则设置为游客模式
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            user = new User();
            user.setId(0);
        }
        // 定义变量
        ArrayList<Comment> comments = new ArrayList<>();
        HashMap<Integer, User> users = userService.getAllUserByMap();
        Integer likes = likeService.getLikeRecordByArticleId(id);
        Integer collects = collectService.getCollectRecordByArticleId(id);

        comments = commentService.getCommentsByArticleId(id);
        articleService.updateArticleViewById(id, comments.size(), likes, collects);

        article = articleService.getArticleById(id);
        if (article == null) {
            return "error/error_404";
        }
        users = userService.getAllUserByMap();
        
        request.setAttribute("userLikeFlag", likeService.vaildUserLikeRecord(article.getId(), user.getId()));
        request.setAttribute("userCollectFlag", collectService.vaildUserCollectRecord(article.getId(), user.getId()));
        request.setAttribute("users", users);
        request.setAttribute("article", article);
        request.setAttribute("comments", comments);
        return "article/detail";
    }

    /**
     * 发布文章页面
     * @param request
     * @return
     */
    @GetMapping("/articlePub")
    public String articlePub(HttpServletRequest request) {
        ArrayList<Category> categorys = new ArrayList<>();
        categorys = categoryService.getAllCategory();
        request.setAttribute("categorys", categorys);
        return "article/articlePub";
    }

    /**
     * 发布文章操作
     * @param title
     * @param content
     * @param categoryID
     * @param verifyCode
     * @param categoryName
     * @param session
     * @return
     */
    @PostMapping("/articlePub")
    @ResponseBody
    public Result articlePub(
            @RequestParam("title") String title, @RequestParam("content") String content,
            @RequestParam("categoryID") String categoryID, @RequestParam("verifyCode") String verifyCode,
            @RequestParam("categoryName") String categoryName, HttpSession session) {

        if (!StringUtils.hasLength(title)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_TITLE.getResult());
        }
        if (!StringUtils.hasLength(content)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_CONTENT.getResult());
        }
        if (!StringUtils.hasLength(categoryName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_CATEGORY.getResult());
        }
        if (!StringUtils.hasLength(verifyCode)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_VERIFYCODE.getResult());
        }
        String captcha = (String) session.getAttribute("VerifyCode");
        if (!verifyCode.equals(captcha)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.WRONG_VERIFYCODE.getResult());
        }

        Article article = new Article();
        User user = (User) session.getAttribute("user");
        article.setUserId(user.getId());
        article.setTitle(title);
        article.setContent(content);
        article.setCategoryID(Integer.parseInt(categoryID));
        article.setCategoryName(categoryName);

        int result = articleService.articlePub(article);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }

    /**
     * 文章编辑页面
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/articleEdit/{id}")
    public String articleEdit(@PathVariable Integer id, HttpServletRequest request) {
        Article article = new Article();
        article = articleService.getArticleById(id);
        request.setAttribute("article", article);
        return "article/articleEdit";
    }

    /**
     * 文章编辑操作
     * @param articleId
     * @param title
     * @param content
     * @param categoryID
     * @param verifyCode
     * @param categoryName
     * @param session
     * @return
     */
    @PostMapping("/articleEdit")
    @ResponseBody
    public Result articleEdit(
            @RequestParam("articleId") String articleId,
            @RequestParam("title") String title, @RequestParam("content") String content,
            @RequestParam("categoryID") String categoryID, @RequestParam("verifyCode") String verifyCode,
            @RequestParam("categoryName") String categoryName, HttpSession session) {
        
        if (!StringUtils.hasLength(title)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_TITLE.getResult());
        }
        if (!StringUtils.hasLength(content)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_CONTENT.getResult());
        }
        if (!StringUtils.hasLength(categoryName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_CATEGORY.getResult());
        }
        if (!StringUtils.hasLength(verifyCode)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NO_VERIFYCODE.getResult());
        }
        String captcha = (String) session.getAttribute("VerifyCode");
        if (!verifyCode.equals(captcha)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.WRONG_VERIFYCODE.getResult());
        }

        int result = articleService.updateArticleById(articleId, title, content, categoryID, categoryName);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult();
        }
    }
    
    /**
     * 解冻文章操作
     * @param arr_id
     * @return
     */
    @PostMapping("/unFreezeArticle")
    @ResponseBody
    public Result unFreezeArticle(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = articleService.updateArticleStatusToNormal(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分帖子审核失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 冻结文章操作
     * @param arr_id
     * @return
     */
    @PostMapping("/freezeArticle")
    @ResponseBody
    public Result freezeArticle(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = articleService.updateArticleStatusToFreeze(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分帖子取消审核失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除文章操作
     * @param arr_id
     * @return
     */
    @PostMapping("/deleteArticle")
    @ResponseBody
    public Result deleteArticle(@RequestParam("arr_id") String arr_id) {
        String[] userId_arr = arr_id.split(",");
        for (String elem : userId_arr) {
            Integer result = articleService.deleteArticleById(Integer.valueOf(elem));
            if (result < 0) {
                return ResultGenerator.genFailResult("部分帖子删除失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 通过id获取文章内容
     * @param id
     * @return
     */
    @GetMapping("/getArticleContentById/{id}")
    @ResponseBody
    public Result getArticleContentById(@PathVariable String id) {
        String result = articleService.getArticleContentById(id);
        return ResultGenerator.genSuccessResult(result);
    }
}
