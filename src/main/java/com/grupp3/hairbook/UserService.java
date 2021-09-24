package com.grupp3.hairbook;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {



    public List<User> getUsers(List<User> userList) {
        return userList;
    }
    public User addUser(User user) {
        return user;
    }
    public void updateUser(){
        User user = new User(7, "hej hej");
    }

// {"id": 10,"name": "firstName41"}
}
