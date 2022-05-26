package com.example.studentbbs.service.imp;

import javax.annotation.Resource;

import com.example.studentbbs.dao.UserDao;
import com.example.studentbbs.entity.User;
import com.example.studentbbs.service.UserService;
import com.example.studentbbs.util.MD5Util;

import org.springframework.stereotype.Service;

@Service
public class UserServiceimp implements UserService {
  @Resource
  private UserDao userDao;
  
  public User login(String loginName, String password) {
    String passwordMD5 = MD5Util.MD5Encode(String.valueOf(loginName) + password, "UTF-8");
    System.out.println(passwordMD5);
    return this.userDao.login(loginName, passwordMD5);
  }
}
