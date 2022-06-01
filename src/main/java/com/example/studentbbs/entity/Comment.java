package com.example.studentbbs.entity;

public class Comment {
    private int id;
    private int postId;
    private int userId;
    private String commentBody;
    private int parentUserId;
    private String createTime;
    private int isDeleted;

    public Comment() {
    }

    public Comment(int id, int postId, int userId, String commentBody, int parentUserId, String createTime, int isDeleted) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.commentBody = commentBody;
        this.parentUserId = parentUserId;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCommentBody() {
        return this.commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public int getParentUserId() {
        return this.parentUserId;
    }

    public void setParentUserId(int parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Comment id(int id) {
        setId(id);
        return this;
    }

    public Comment postId(int postId) {
        setPostId(postId);
        return this;
    }

    public Comment userId(int userId) {
        setUserId(userId);
        return this;
    }

    public Comment commentBody(String commentBody) {
        setCommentBody(commentBody);
        return this;
    }

    public Comment parentUserId(int parentUserId) {
        setParentUserId(parentUserId);
        return this;
    }

    public Comment createTime(String createTime) {
        setCreateTime(createTime);
        return this;
    }

    public Comment isDeleted(int isDeleted) {
        setIsDeleted(isDeleted);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", postId='" + getPostId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", commentBody='" + getCommentBody() + "'" +
            ", parentUserId='" + getParentUserId() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            "}";
    }

}
