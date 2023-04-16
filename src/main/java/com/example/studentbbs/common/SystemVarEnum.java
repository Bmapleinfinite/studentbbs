package com.example.studentbbs.common;

public enum SystemVarEnum {

    FILE_UPLOAD_DIC(System.getProperty("user.dir") + "/upload/");

    private String value;

    public String getValue() {
        return value;
    }

    SystemVarEnum(String value) {
        this.value = value;
    }

}
