package com.learn.security.repository;

import com.learn.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomUserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String name);
}
