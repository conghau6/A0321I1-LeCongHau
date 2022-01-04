package com.codegym.furama.repositories.employee;

import com.codegym.furama.entity.Role;
import com.codegym.furama.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepositories extends JpaRepository<User,String> {
    User findByUsername(String username);

    @Query("select u.roles from User u where u.username = :username")
    List<Role> findAllRoleByUsername(String username);
}
