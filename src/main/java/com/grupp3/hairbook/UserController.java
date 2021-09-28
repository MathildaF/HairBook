package com.grupp3.hairbook;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

        this.userService.addUser(new User( "name1", true));
        this.userService.addUser(new User( "name2", false));
        this.userService.addUser(new User( "name3", false));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try{
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/hello")
    public @ResponseBody String getText() {
        return "Hello all bad hair dayers!";
    }

    //Create
    @PostMapping("/user") //I Headers måste man ha (KEY)Content-type samt (VALUE)application/json
    public User addUser(@RequestBody UserModel userModel){
        return this.userService.addUser(new User(userModel.getName(), userModel.isHasBadHairDay()));
    }

    //Update
    @PutMapping("/user/{id}")    // id i sökväg                         //I Headers måste man ha (KEY)Content-type samt (VALUE)application/json
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserModel usermodel){

        try{
            return new ResponseEntity<>(userService.updateUser(id, usermodel), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")

    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        try{
            return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }
}
