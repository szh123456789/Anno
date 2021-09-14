package com.entity;

import com.dao.User;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public User findUserById(Integer id){
        if (id > 10){
            return null;
        }
        User user = new User(id,"User-"+id);
        System.out.println("返回的用户"+user.toString());
        return user;
    }
}
