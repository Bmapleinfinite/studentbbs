package com.example.studentbbs.entity;

public class Article {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int categoryID;
    private String categoryName;
    private String articleStatus;
    private int views;
    private int comments;
    private int collects;
    private int likes;
    private String lastUpdateTime;
    private String createTime;


    public Article() {
    }

    public Article(int id, int userId, String title, String content, int categoryID, String categoryName, String articleStatus, int views, int comments, int collects, int likes, String lastUpdateTime, String createTime) {
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

    public String getArticleStatus() {
        return this.articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
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

    public Article articleStatus(String articleStatus) {
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
