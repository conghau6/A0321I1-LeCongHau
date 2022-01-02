package com.codegym.furama.repositories;

import com.codegym.furama.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerType extends JpaRepository<CustomerType,Integer> {
}
