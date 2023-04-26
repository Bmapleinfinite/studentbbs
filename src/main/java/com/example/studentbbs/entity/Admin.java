/**
 * 管理员实体类
 */
package com.example.studentbbs.entity;

public class Admin {
    private Long adminId;

    private String loginName;

    private String loginPassword;

    private String adminNickName;

    private String adminLevel;

    private Byte locked;

    public Admin() {
    }

    public Admin(Long adminId, String loginName, String loginPassword, String adminNickName, String adminLevel, Byte locked) {
        this.adminId = adminId;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.adminNickName = adminNickName;
        this.adminLevel = adminLevel;
        this.locked = locked;
    }

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
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getAdminNickName() {
        return this.adminNickName;
    }

    public void setAdminNickName(String adminNickName) {
        this.adminNickName = adminNickName;
    }

    public String getAdminLevel() {
        return this.adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public Byte getLocked() {
        return this.locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    public Admin adminId(Long adminId) {
        setAdminId(adminId);
        return this;
    }

    public Admin loginName(String loginName) {
        setLoginName(loginName);
        return this;
    }

    public Admin loginPassword(String loginPassword) {
        setLoginPassword(loginPassword);
        return this;
    }

    public Admin adminNickName(String adminNickName) {
        setAdminNickName(adminNickName);
        return this;
    }

    public Admin adminLevel(String adminLevel) {
        setAdminLevel(adminLevel);
        return this;
    }

    public Admin locked(Byte locked) {
        setLocked(locked);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " adminId='" + getAdminId() + "'" +
            ", loginName='" + getLoginName() + "'" +
            ", loginPassword='" + getLoginPassword() + "'" +
            ", adminNickName='" + getAdminNickName() + "'" +
            ", adminLevel='" + getAdminLevel() + "'" +
            ", locked='" + getLocked() + "'" +
            "}";
    }
    
}
