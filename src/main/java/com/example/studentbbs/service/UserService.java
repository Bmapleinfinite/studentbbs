package com.example.studentbbs.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.studentbbs.entity.User;

public interface UserService {
    User login(String loginName, String password);

    User getUserByLoginName(String loginName);

    Integer register(User user);

    Integer updateLastLoginTimeById(Integer id);

    HashMap<Integer, User> getAllUserByMap();

    Integer updateUserInfoById(Integer userId, String nickName, String gender, String location, String introduce);

    Integer updateUserPass(Integer userId, String passwordMD5);

    User getUserById(Integer userId);

    Integer headImgUpdateById(String headImg, Integer userId);

    ArrayList<User> getAllUser();

    Integer updateUserStatusToNormal(Integer userId);

    Integer updateUserStatusToFreeze(Integer userId);
}
