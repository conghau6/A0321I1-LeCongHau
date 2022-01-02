package com.codegym.furama.repositories.employee;

import com.codegym.furama.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepositories extends JpaRepository<User,Integer> {
}
