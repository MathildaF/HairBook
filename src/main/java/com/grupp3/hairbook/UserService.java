package com.grupp3.hairbook;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();

    public List<User> getUsers() {
        return this.userList;
    }

    public User getUser(Long id) {
        return this.getUsers()                         //Alla användare
                .stream()                              //Hämtar alla i listan
                .filter(user -> user.getId()==id)      //for loop som returnar när den hittar id på användare
                .findFirst()                           //returnerar första resultatet i loopen
                .orElse(null);                    // & hittar den ingen returnerar den null
    }

    public User addUser(User user) {
        this.userList.add(user);

        return user;
    }

    public User updateUser(User user){

        return this.getUsers()
                .stream()
                .filter(updateUser -> {
                    if (updateUser.getId()==user.getId()) {
                        updateUser.setName(user.getName());
                        return true;
                    }
                    return false;
                })
                .findFirst()
                .orElse(null);
    }

    public User deleteUser(Long id){

        User user = this.getUsers()
                .stream()
                .filter(deleteUser -> {
                    if (deleteUser.getId()==id) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .findFirst()
                .orElse(null);

        if (user != null) {
            this.userList.remove(user);
            return user;
        } else {
            return null;
        }
    }

}
