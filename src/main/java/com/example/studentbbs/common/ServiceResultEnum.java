package com.example.studentbbs.common;

public enum ServiceResultEnum {
    USER_NOT_EXCIT("用户不存在！"),

    NO_LOGIN_NAME("请输入用户名！"),

    NOT_EMAIL("请输入正确的用户名！"),

    NO_PASSWORD("请输入密码！"),

    NO_VERIFYCODE("请输入验证码"),

    WRONG_VERIFYCODE("错误的验证码！"),
    
    NO_USER("用户名或密码错误！");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
