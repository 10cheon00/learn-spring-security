package com.learn.security.controller;

import com.learn.security.entity.Users;
import com.learn.security.service.CustomUserDetailsService;
import com.learn.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userDetailsService;

    @Autowired
    public UserController(UserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Users> getUsers() {
        return userDetailsService.findAll();
    }

    @PostMapping("")
    @ResponseBody
    public Users createUser(@RequestBody Users user) {
        return userDetailsService.create(user);
    }
}
