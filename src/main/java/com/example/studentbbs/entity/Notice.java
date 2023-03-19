package com.example.studentbbs.entity;

import java.util.Date;

/**
 * (TbBbsNotice)实体类
 *
 * @author makejava
 * @since 2023-03-19 18:29:00
 */
public class Notice{
    /**
     * 通知ID
     */
    private Long id;
    /**
     * 通知名称
     */
    private String noticeName;
    /**
     * 通知类型
     */
    private Integer noticeType;
    /**
     * 是否已查看
     */
    private Boolean isChecked;
    /**
     * 创建时间
     */
    private Date createTime;
    
    private String toUserId;
    
    private String fromUserId;

    /**
     * 通知内容
     */
    private String noticeContent;

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", noticeName='" + noticeName + '\'' +
                ", noticeType=" + noticeType +
                ", isChecked=" + isChecked +
                ", createTime=" + createTime +
                ", toUserId='" + toUserId + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                '}';
    }
}

