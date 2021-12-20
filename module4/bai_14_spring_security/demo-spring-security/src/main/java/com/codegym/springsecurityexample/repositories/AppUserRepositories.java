package com.codegym.springsecurityexample.repositories;

import com.codegym.springsecurityexample.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepositories extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
