package com.codegym.blog.repositories;

import com.codegym.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
