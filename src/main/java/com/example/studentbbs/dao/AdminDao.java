package com.example.studentbbs.dao;

import com.example.studentbbs.entity.Admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AdminDao {
    Admin login(@Param("username") String paramString1, @Param("password") String paramString2);
}
