package com.example.studentbbs.dao;

import com.example.studentbbs.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    User login(@Param("loginName") String paramString1, @Param("password") String paramString2);
}
