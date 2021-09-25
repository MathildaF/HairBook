package com.grupp3.hairbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
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
        return this.userService.getUser(id);
    }

    //Create
    @PostMapping("/user")                            //I Headers måste man ha (KEY)Content-type samt (VALUE)application/json
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
    //Update
    @PutMapping("/user")                             //I Headers måste man ha (KEY)Content-type samt (VALUE)application/json
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
