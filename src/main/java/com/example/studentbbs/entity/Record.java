package com.example.studentbbs.entity;

public class Record {
    private int id;
    private int postId;
    private int userId;
    private String createTime;

    public Record() {
    }

    public Record(int id, int postId, int userId, String createTime) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.createTime = createTime;
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

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Record id(int id) {
        setId(id);
        return this;
    }

    public Record postId(int postId) {
        setPostId(postId);
        return this;
    }

    public Record userId(int userId) {
        setUserId(userId);
        return this;
    }

    public Record createTime(String createTime) {
        setCreateTime(createTime);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", postId='" + getPostId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }

}
