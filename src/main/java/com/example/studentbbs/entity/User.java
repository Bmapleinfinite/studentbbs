package com.example.studentbbs.entity;

public class User {
    private int id;

    private String loginName;

    private String password;

    private String nickName;

    private String headImgUrl;

    private String gender;

    private String location;

    private String introduce;

    private int userStatus;

    private String lastLoginTime;

    private String createTime;

    public User() {
    }

    public User(int id, String loginName, String password, String nickName, String headImgUrl, String gender,
            String location, String introduce, int userStatus, String lastLoginTime, String createTime) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.nickName = nickName;
        this.headImgUrl = headImgUrl;
        this.gender = gender;
        this.location = location;
        this.introduce = introduce;
        this.userStatus = userStatus;
        this.lastLoginTime = lastLoginTime;
        this.createTime = createTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        return this.headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public User id(int id) {
        setId(id);
        return this;
    }

    public User loginName(String loginName) {
        setLoginName(loginName);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User nickName(String nickName) {
        setNickName(nickName);
        return this;
    }

    public User headImgUrl(String headImgUrl) {
        setHeadImgUrl(headImgUrl);
        return this;
    }

    public User gender(String gender) {
        setGender(gender);
        return this;
    }

    public User location(String location) {
        setLocation(location);
        return this;
    }

    public User introduce(String introduce) {
        setIntroduce(introduce);
        return this;
    }

    public User userStatus(int userStatus) {
        setUserStatus(userStatus);
        return this;
    }

    public User lastLoginTime(String lastLoginTime) {
        setLastLoginTime(lastLoginTime);
        return this;
    }

    public User createTime(String createTime) {
        setCreateTime(createTime);
        return this;
    }

    public String toString() {
        return "{ id='" +
                getId() + "'" +
                ", loginName='" + getLoginName() + "'" +
                ", password='" + getPassword() + "'" +
                ", nickName='" + getNickName() + "'" +
                ", headImgUrl='" + getHeadImgUrl() + "'" +
                ", gender='" + getGender() + "'" +
                ", location='" + getLocation() + "'" +
                ", introduce='" + getIntroduce() + "'" +
                ", userStatus='" + getUserStatus() + "'" +
                ", lastLoginTime='" + getLastLoginTime() + "'" +
                ", createTime='" + getCreateTime() + "'" +
                "}";
    }
}
