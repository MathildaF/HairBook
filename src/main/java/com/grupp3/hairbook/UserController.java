package com.grupp3.hairbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users") //gammal metod?
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @PostMapping()
    public User addUser(@RequestBody User user){
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
