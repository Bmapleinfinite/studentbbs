package com.example.studentbbs.service;

import com.example.studentbbs.entity.Admin;

public interface AdminService {
    Admin login(String loginName, String password);
}
