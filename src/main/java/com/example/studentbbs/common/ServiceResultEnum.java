package com.example.studentbbs.common;

public enum ServiceResultEnum {
    USER_NOT_EXCIT("用户不存在！"),

    USER_EXCIT("用户已存在！"),

    NO_LOGIN_NAME("请输入用户名！"),

    NO_NICKNAME("请输入昵称！"),

    NOT_EMAIL("请输入正确的用户名！"),

    NO_GENDER("请选择性别！"),

    NO_PASSWORD("请输入密码！"),

    NO_VERIFYCODE("请输入验证码"),

    WRONG_VERIFYCODE("错误的验证码！"),

    WRONG_NOW_PASSWORD("原密码不正确！"),

    SAME_PASS("新密码不能与原密码相同！"),

    DEFAULT_UNKNOW("未知"),

    DEFAULT_INTRODUCE("这个人很懒，什么都没留下~"),

    DEFAULT_HEADIMGURL("/images/avatar/default.png"),
    
    NO_USER("用户名或密码错误！"),

    NO_CATEGORY("请选择分类"), 

    NO_CONTENT("请输入正文"),

    NO_TITLE("请输入标题");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
