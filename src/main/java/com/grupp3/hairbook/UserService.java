package com.grupp3.hairbook;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public User getUserById(long id) {
        Optional<User> optionalUser = this.getUsers()
                .stream()
                .filter(user -> user.getId()==id)
                .findFirst();
        return optionalUser.get();

        }

    public User addUser(User user) {
        this.userList.add(user);
        return user;
    }

    public User updateUser(Long id, UserModel usermodel){

        Optional<User> optionalUser = this.getUsers()
                .stream()
                .filter(updateUser -> {
                    if (updateUser.getId()==id) {
                        updateUser.setName(usermodel.getName());
                        updateUser.setHasBadHairDay(usermodel.isHasBadHairDay());
                        return true;
                    }
                    return false;
                })
                .findFirst();
        return optionalUser.get();
    }

    public User deleteUser(Long id){

        Optional<User> optionalUser = this.getUsers()
                .stream()
                .filter(deleteUser -> {
                    if (deleteUser.getId()==id) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .findFirst();

        if (optionalUser.isPresent()) {
            this.userList.remove(optionalUser.get());
        }
        return optionalUser.get();
    }

}
