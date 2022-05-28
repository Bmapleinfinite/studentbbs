package com.example.studentbbs.entity;

public class Category {
    private int id;
    private String categoryName;
    private int categoryRank;
    private int isDeleted;
    private String createTime;

    public Category() {
    }

    public Category(int id, String categoryName, int categoryRank, int isDeleted, String createTime) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryRank = categoryRank;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryRank() {
        return this.categoryRank;
    }

    public void setCategoryRank(int categoryRank) {
        this.categoryRank = categoryRank;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Category id(int id) {
        setId(id);
        return this;
    }

    public Category categoryName(String categoryName) {
        setCategoryName(categoryName);
        return this;
    }

    public Category categoryRank(int categoryRank) {
        setCategoryRank(categoryRank);
        return this;
    }

    public Category isDeleted(int isDeleted) {
        setIsDeleted(isDeleted);
        return this;
    }

    public Category createTime(String createTime) {
        setCreateTime(createTime);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", categoryName='" + getCategoryName() + "'" +
            ", categoryRank='" + getCategoryRank() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }

}
