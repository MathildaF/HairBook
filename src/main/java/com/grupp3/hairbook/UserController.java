package com.grupp3.hairbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api") //gammal metod? //
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

        this.userService.addUser(new User(1, "name1"));
        this.userService.addUser(new User(2, "name2"));
        this.userService.addUser(new User(3, "name3"));
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return this.userService
                .getUsers()                             //Alla användare
                .stream()                              //Hämtar alla i listan
                .filter(user -> user.getId()==id)      //for loop som returnar när den hittar id på användare
                .findFirst()                           //returnerar första resultatet i loopen
                .orElse(null);                   // & hittar den ingen returnerar den null
    }

    @PostMapping("/user") //Create
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
    @PutMapping() //Update
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping()
    public User deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }
}
