package com.grupp3.hairbook;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers(List<User> userList) {
        return userList;
    }

    public User addUser(User user) {
        return user;
    }

    public User updateUser(User user){
        return user;
    }

    public User deleteUser(User user){
        return user;
    }

}
