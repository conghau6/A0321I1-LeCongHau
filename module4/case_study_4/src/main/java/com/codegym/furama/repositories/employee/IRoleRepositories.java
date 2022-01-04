package com.codegym.furama.repositories.employee;

import com.codegym.furama.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleRepositories extends JpaRepository<Role,Integer> {

}
