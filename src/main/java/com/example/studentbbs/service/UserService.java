package com.example.studentbbs.service;

import com.example.studentbbs.entity.User;

public interface UserService {
    User login(String loginName, String password);

    User getUserByLoginName(String loginName);

    Integer register(User user);

    Integer updateLastLoginTimeById(Integer id);
}
