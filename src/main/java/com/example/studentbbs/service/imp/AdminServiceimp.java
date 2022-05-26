package com.example.studentbbs.service.imp;

import javax.annotation.Resource;

import com.example.studentbbs.dao.AdminDao;
import com.example.studentbbs.entity.Admin;
import com.example.studentbbs.service.AdminService;
import com.example.studentbbs.util.MD5Util;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceimp implements AdminService {
    @Resource
    private AdminDao adminDao;

    public Admin login(String username, String password) {
        String passwordMd5 = MD5Util.MD5Encode(String.valueOf(password) + username, "UTF-8");
        return this.adminDao.login(username, passwordMd5);
    }
}
