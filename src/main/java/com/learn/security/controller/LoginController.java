package com.learn.security.controller;

import com.learn.security.entity.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("login/")
@RestController
public class LoginController {
    @GetMapping("")
    @ResponseBody
    public User login() {
        return null;
    }
}
