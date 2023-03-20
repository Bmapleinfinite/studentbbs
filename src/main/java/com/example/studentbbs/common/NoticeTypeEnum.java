package com.example.studentbbs.common;

public enum NoticeTypeEnum {

    NOTICE_TYPE_REPLY(2),

    NOTICE_TYPE_SYSTEM(1),
    
    NOTICE_TYPE_SECRET(3);
    private Integer type;

    public Integer getType() {
        return type;
    }

    NoticeTypeEnum(Integer type) {
        this.type = type;
    }
}
