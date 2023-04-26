/**
 * 用户数据访问对象
 */
package com.example.studentbbs.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.studentbbs.dto.CommonDataDto;
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
    HashMap<Integer, User> getAllUserByMap();

    Integer updateUserInfoById(Integer userId, String nickName, String gender, String location, String introduce);

    Integer updateUserPass(Integer userId, String passwordMD5);

    User getUserById(Integer userId);

    Integer headImgUpdateById(String headImg, Integer userId);

    ArrayList<User> getAllUser();

    Integer updateUserStatusToNormal(Integer userId);

    Integer updateUserStatusToFreeze(Integer userId);

    Integer deleteUserById(Integer userId);

    Integer getLoginNum(Integer count, String strDate);

    ArrayList<CommonDataDto> getSexualFBData();
}
