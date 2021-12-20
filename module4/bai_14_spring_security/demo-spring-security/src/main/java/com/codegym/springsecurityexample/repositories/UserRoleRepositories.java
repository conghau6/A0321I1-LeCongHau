package com.codegym.springsecurityexample.repositories;

import com.codegym.springsecurityexample.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepositories extends JpaRepository<UserRole,Long> {
}
