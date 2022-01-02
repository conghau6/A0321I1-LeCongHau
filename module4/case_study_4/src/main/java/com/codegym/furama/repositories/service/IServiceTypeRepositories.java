package com.codegym.furama.repositories.service;

import com.codegym.furama.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepositories extends JpaRepository<ServiceType, Integer> {
}
