package com.grupp3.hairbook;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        List<User> userList = Arrays.asList(
                new User(1, "name1"),
                new User(2, "name2"),
                new User(3, "name3")
        );
        return userList;
    }

    public User addUser(User user) {
        //User testUser = new User(7, "hej hej");
        return user;
    }

}
