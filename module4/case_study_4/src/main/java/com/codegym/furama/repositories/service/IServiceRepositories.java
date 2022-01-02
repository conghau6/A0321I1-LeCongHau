package com.codegym.furama.repositories.service;

import com.codegym.furama.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepositories extends JpaRepository<Service,Integer> {
}
