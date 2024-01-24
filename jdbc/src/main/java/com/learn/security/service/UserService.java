package com.learn.security.service;

import com.learn.security.entity.Users;
import com.learn.security.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final CustomUserRepository userRepository;

    public UserService(CustomUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users create(Users user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return userRepository.save(user);
    }
}
