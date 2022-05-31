package com.example.studentbbs.dao;

import java.util.HashMap;

import com.example.studentbbs.entity.User;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    User login(@Param("loginName") String loginName, @Param("password") String password);

    Integer register(User user);

    User getUserByLoginName(String loginName);

    Integer updateLastLoginTimeById(Integer id);

    @MapKey("id")
    HashMap<Integer, User> getAllUser();
}
