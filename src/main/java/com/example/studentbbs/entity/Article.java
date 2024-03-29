/**
 * 文章实体类
 */
package com.example.studentbbs.entity;

public class Article {
    private int id; /*帖子主键id*/
    private int userId; /*发布者id*/
    private String title; /*帖子标题*/
    private String content; /*帖子内容*/
    private int categoryID; /*帖子分类id*/
    private String categoryName; /*帖子分类(冗余字段)*/
    private int articleStatus; /*0-未审核 1-审核通过 2-审核失败 (默认未审核)*/
    private int views; /*阅读量*/
    private int comments; /*评论量*/
    private int collects; /*收藏量*/
    private int likes; /*点赞数*/
    private String lastUpdateTime; /*最新修改时间*/
    private String createTime; /*添加时间*/


    public Article() {
    }

    public Article(int id, int userId, String title, String content, int categoryID, String categoryName, int articleStatus, int views, int comments, int collects, int likes, String lastUpdateTime, String createTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.articleStatus = articleStatus;
        this.views = views;
        this.comments = comments;
        this.collects = collects;
        this.likes = likes;
        this.lastUpdateTime = lastUpdateTime;
        this.createTime = createTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryID() {
        return this.categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getArticleStatus() {
        return this.articleStatus;
    }

    public void setArticleStatus(int articleStatus) {
        this.articleStatus = articleStatus;
    }

    public int getViews() {
        return this.views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getComments() {
        return this.comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getCollects() {
        return this.collects;
    }

    public void setCollects(int collects) {
        this.collects = collects;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Article id(int id) {
        setId(id);
        return this;
    }

    public Article userId(int userId) {
        setUserId(userId);
        return this;
    }

    public Article title(String title) {
        setTitle(title);
        return this;
    }

    public Article content(String content) {
        setContent(content);
        return this;
    }

    public Article categoryID(int categoryID) {
        setCategoryID(categoryID);
        return this;
    }

    public Article categoryName(String categoryName) {
        setCategoryName(categoryName);
        return this;
    }

    public Article articleStatus(int articleStatus) {
        setArticleStatus(articleStatus);
        return this;
    }

    public Article views(int views) {
        setViews(views);
        return this;
    }

    public Article comments(int comments) {
        setComments(comments);
        return this;
    }

    public Article collects(int collects) {
        setCollects(collects);
        return this;
    }

    public Article like(int like) {
        setLikes(like);
        return this;
    }

    public Article lastUpdateTime(String lastUpdateTime) {
        setLastUpdateTime(lastUpdateTime);
        return this;
    }

    public Article createTime(String createTime) {
        setCreateTime(createTime);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", title='" + getTitle() + "'" +
            ", content='" + getContent() + "'" +
            ", categoryID='" + getCategoryID() + "'" +
            ", categoryName='" + getCategoryName() + "'" +
            ", articleStatus='" + getArticleStatus() + "'" +
            ", views='" + getViews() + "'" +
            ", comments='" + getComments() + "'" +
            ", collects='" + getCollects() + "'" +
            ", like='" + getLikes() + "'" +
            ", lastUpdateTime='" + getLastUpdateTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }

    

}
