package com.service;

import com.dao.User;
import com.entity.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public User findUserById(Integer id){
        return userDao.findUserById(id);
    }
}
