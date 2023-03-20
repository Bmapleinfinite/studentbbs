package com.example.studentbbs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import com.example.studentbbs.dao.UserDao;
import com.example.studentbbs.dto.CommonDataDto;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.UserService;
import com.example.studentbbs.util.MD5Util;

import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Resource
    private UserDao userDao;

    public User login(String loginName, String password) {
        String passwordMD5 = MD5Util.MD5Encode(String.valueOf(loginName) + password, "UTF-8");
        return userDao.login(loginName, passwordMD5);
    }

    @Override
    public Integer register(User user) {
        if (userDao.getUserByLoginName(user.getLoginName()) != null) {
            return 0;
        }
        String passwordMD5 = MD5Util.MD5Encode(user.getLoginName() + user.getPassword(), "UTF-8");
        user.setPassword(passwordMD5);
        return userDao.register(user);
    }

    @Override
    public User getUserByLoginName(String loginName) {
        return userDao.getUserByLoginName(loginName);
    }

    @Override
    public Integer updateLastLoginTimeById(Integer id) {
        return userDao.updateLastLoginTimeById(id);
    }

    @Override
    public HashMap<Integer, User> getAllUserByMap() {
        return userDao.getAllUserByMap();
    }

    @Override
    public Integer updateUserInfoById(Integer userId, String nickName, String gender, String location, String introduce) {
        return userDao.updateUserInfoById(userId, nickName, gender, location, introduce);
    }

    @Override
    public Integer updateUserPass(Integer userId, String passwordMD5) {
        return userDao.updateUserPass(userId, passwordMD5);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer headImgUpdateById(String headImg, Integer userId) {
        return userDao.headImgUpdateById(headImg, userId);
    }

    @Override
    public ArrayList<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public Integer updateUserStatusToNormal(Integer userId) {
        return userDao.updateUserStatusToNormal(userId);
    }

    @Override
    public Integer updateUserStatusToFreeze(Integer userId) {
        return userDao.updateUserStatusToFreeze(userId);
    }

    @Override
    public Integer deleteUserById(Integer userId) {
        return userDao.deleteUserById(userId);
    }

    @Override
    public ArrayList<Integer> getLoginNum() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(userDao.getLoginNum(1, "YEAR"));
        result.add(userDao.getLoginNum(6, "MONTH"));
        result.add(userDao.getLoginNum(1, "MONTH"));
        result.add(userDao.getLoginNum(1, "WEEK"));
        result.add(userDao.getLoginNum(1, "DAY"));
        return result;
    }

    @Override
    public ArrayList<CommonDataDto> getSexualFBData() {
        return userDao.getSexualFBData();
    }
}