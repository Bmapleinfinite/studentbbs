/**
 * 通知类型枚举
 */
package com.example.studentbbs.common;

public enum NoticeTypeEnum {

    /* 回复通知 */
    NOTICE_TYPE_REPLY(2),

    /* 系统通知 */
    NOTICE_TYPE_SYSTEM(1),
    
    /* 私信通知 */
    NOTICE_TYPE_SECRET(3);
    
    private Integer type;

    public Integer getType() {
        return type;
    }

    NoticeTypeEnum(Integer type) {
        this.type = type;
    }
}
