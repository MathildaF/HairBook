package com.grupp3.hairbook;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    List<User> userList = Arrays.asList(
            new User(1, "name1"),
            new User(2, "name2"),
            new User(3, "name3")
    );
    public List<User> getUsers() {
        return userList;
    }

    public User addUser(User user) {
        userList.add(user);
        return user;
    }
    public void updateUser(){
        User user = new User(7, "hej hej");

    }

}
