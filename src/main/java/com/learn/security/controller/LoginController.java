package com.learn.security.controller;

import com.learn.security.AuthResponseDTO;
import com.learn.security.JwtGenerator;
import com.learn.security.entity.User;
import com.learn.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/auth")
@RestController
public class LoginController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;

    @Autowired
    public LoginController(UserService userService, AuthenticationManager authenticationManager, JwtGenerator jwtGenerator) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @GetMapping("")
    @ResponseBody
    public String test() {
        return "test";
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
    public AuthResponseDTO signIn(@RequestBody User user) {
        /*
        기본적으로 Username + Password로 인증을 진행할 때에는
        내부 필터에서 AuthenticationManager가 직접 authenticate를 실행하여
        유효한 사용자인지 판단했다.
        그런 인증 절차를 거친 후에 토큰을 생성하여 반환한다.
         */
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        System.out.println(token);
        return new AuthResponseDTO(token);
    }

}
