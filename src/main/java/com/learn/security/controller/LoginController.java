package com.learn.security.controller;

import com.learn.security.entity.User;
import com.learn.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/auth")
@RestController
public class LoginController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public LoginController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("")
    @ResponseBody
    public User join(@RequestBody User user) {
        Optional<User> joinedUser = userService.join(user);
        return joinedUser.get();
    }

    // 테스트를 위해 만든 임시 로그인
    @PostMapping("/signin")
    @ResponseBody
    public String signIn(@RequestBody User user) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(user.getUsername(), user.getPassword());
        try {
            authenticationManager.authenticate(authenticationRequest);
            return "authenticated";
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return "not authenticated";
    }

}
