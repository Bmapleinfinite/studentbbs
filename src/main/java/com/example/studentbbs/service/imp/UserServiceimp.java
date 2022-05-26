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
}
