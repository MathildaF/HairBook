package com.grupp3.hairbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users") //gammal metod?
public class UserController {
    private final UserService userService;

    List<User> userList = new ArrayList<>(Arrays.asList(
            new User(1, "name1"),
            new User(2, "name2"),
            new User(3, "name3")));

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() {
        List<User> userList = this.userList;
        return userService.getUsers(userList);
    }
    @PostMapping()
    public User addUser(@RequestBody User user){
        userList.add(user);
        return userService.addUser(user);
    }

    //Hårdkodad lista för övning
    @GetMapping("/list")
    public  List<String> getList() {
        List<String> listTest = Arrays.asList("Item1", "Item2", "Item3");
        return listTest;
    }

    @GetMapping("/test")
    public String getUser() {
        return "GET request";
    }

    @PostMapping("/test")
    public String postUsers() {
        return "POST request";
    }

    @PutMapping("/test")
    public String updateUsers() {
        return "UPDATE request";
    }

    @DeleteMapping("/test")
    public String deleteUsers() {
        return "DELETE request";
    }

}
