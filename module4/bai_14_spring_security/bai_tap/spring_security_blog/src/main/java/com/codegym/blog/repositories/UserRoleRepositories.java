package com.codegym.blog.repositories;

import com.codegym.blog.model.User;
import com.codegym.blog.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepositories extends JpaRepository<UserRole,Integer> {
    List<UserRole> findAllByUser(User user);

    @Query("select ur.role.roleName from UserRole ur where ur.user.id = :userId")
    List<String> findAllRoleByUserId(Integer userId);
}
