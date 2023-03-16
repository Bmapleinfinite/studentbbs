package com.example.studentbbs.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.studentbbs.entity.User;

public interface UserService {
    /**
     * 用户登录
     * @param loginName 用户名
     * @param password 密码
     * @return
     */
    User login(String loginName, String password);

    /**
     * 通过用户名获取用户
     * @param loginName 用户名
     * @return
     */
    User getUserByLoginName(String loginName);

    /**
     * 用户注册
     * @param user
     * @return
     */
    Integer register(User user);

    /**
     * 更新用户登陆时间
     * @param id 用户ID
     * @return
     */
    Integer updateLastLoginTimeById(Integer id);

    /**
     * 以ID为key 获取用户集合
     * @return
     */
    HashMap<Integer, User> getAllUserByMap();

    /**
     * 更新用户信息
     * 
     * @param userId 用户id
     * @param nickName 昵称
     * @param gender 性别
     * @param location 住址
     * @param introduce 个人简介
     * @return
     */
    Integer updateUserInfoById(Integer userId, String nickName, String gender, String location, String introduce);

    /**
     * 更新用户密码
     * 
     * @param userId 用户id
     * @param passwordMD5 MD5算法加密后的密码
     * @return
     */
    Integer updateUserPass(Integer userId, String passwordMD5);

    /**
     * 通过ID获取用户对象
     * @param userId 用户ID
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 根据用户ID更新用户头像
     * 
     * @param headImg 用户新头像路径
     * @param userId 用户id
     * @return
     */
    Integer headImgUpdateById(String headImg, Integer userId);

    /**
     * 获取所有用户
     * @return
     */
    ArrayList<User> getAllUser();

    /**
     * 解冻用户
     * @param userId 用户id
     * @return
     */
    Integer updateUserStatusToNormal(Integer userId);

    /**
     * 冻结用户
     * @param userId 用户id
     * @return
     */
    Integer updateUserStatusToFreeze(Integer userId);

    /**
     * 删除文章ID
     * @param userId 用户id
     * @return
     */
    Integer deleteUserById(Integer userId);
}
