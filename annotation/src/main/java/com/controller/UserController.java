package com.controller;


import com.anno.Anno;
import com.dao.User;
import com.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @Anno("============================  ")
    @RequestMapping("user/{id}")
    public User findUser(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }
}
