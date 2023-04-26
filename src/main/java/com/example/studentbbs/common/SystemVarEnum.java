/**
 * 系统变量枚举
 */
package com.example.studentbbs.common;

public enum SystemVarEnum {

    /* 获取上传文件的存放路径 */
    FILE_UPLOAD_DIC(System.getProperty("user.dir") + "\\upload\\");

    private String value;

    public String getValue() {
        return value;
    }

    SystemVarEnum(String value) {
        this.value = value;
    }

}
