package com.grupp3.hairbook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();

    public List<User> getUsers() {
        return this.userList;
    }

    public User addUser(User user) {
        this.userList.add(user);

        return user;
    }

    public User updateUser(User user){

        return this.getUsers().stream().filter(updateUser -> {
            if (updateUser.getId()==user.getId()) {
                updateUser.setName(user.getName());
                return true;
            }
                return false;
        })
        .findFirst()
        .orElse(null);
    }

    public User deleteUser(User user){

        return user;
    }

}
