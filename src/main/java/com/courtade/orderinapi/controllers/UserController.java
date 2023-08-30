package com.courtade.orderinapi.controllers;

import com.courtade.orderinapi.entities.User;
import com.courtade.orderinapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new RuntimeException("User id not found " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new RuntimeException("User id not found " + id);
        }
        userService.deleteById(id);
    }
}
