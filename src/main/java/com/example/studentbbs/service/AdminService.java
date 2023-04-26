/**
 * 管理员服务类
 */
package com.example.studentbbs.service;

import com.example.studentbbs.entity.Admin;

public interface AdminService {
    /**
     * 管理员用户登录
     * @param loginName
     * @param password
     * @return
     */
    Admin login(String loginName, String password);
}
