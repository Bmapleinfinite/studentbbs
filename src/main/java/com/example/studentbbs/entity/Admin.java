package com.example.studentbbs.entity;

public class Admin {
    private Long adminId;

    private String loginName;

    private String loginPassword;

    private String adminNickName;

    private Byte locked;

    public Long getAdminId() {
        return this.adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = (loginName == null) ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = (loginPassword == null) ? null : loginPassword.trim();
    }

    public String getAdminNickName() {
        return this.adminNickName;
    }

    public void setAdminNickName(String adminNickName) {
        this.adminNickName = (adminNickName == null) ? null : adminNickName.trim();
    }

    public Byte getLocked() {
        return this.locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(this.adminId);
        sb.append(", loginName=").append(this.loginName);
        sb.append(", loginPassword=").append(this.loginPassword);
        sb.append(", adminNickName=").append(this.adminNickName);
        sb.append(", locked=").append(this.locked);
        sb.append("]");
        return sb.toString();
    }
}
