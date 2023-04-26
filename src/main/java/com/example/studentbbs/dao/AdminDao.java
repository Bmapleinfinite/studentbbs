/**
 * 管理员数据访问对象
 */
package com.example.studentbbs.dao;

import com.example.studentbbs.entity.Admin;

import org.springframework.stereotype.Component;

@Component
public interface AdminDao {
    Admin login(String username, String password);
}
