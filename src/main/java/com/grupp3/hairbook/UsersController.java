package com.grupp3.hairbook;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping() //("/get")
    public String getUsers() {
        return "GET request";
    }

    @PostMapping() //("/post")
    public String postUsers() {
        return "POST request";
    }

    @PutMapping()
    public String updateUsers() {
        return "UPDATE request";
    }

    @DeleteMapping()
    public String deleteUsers() {
        return "DELETE request";
    }

}
