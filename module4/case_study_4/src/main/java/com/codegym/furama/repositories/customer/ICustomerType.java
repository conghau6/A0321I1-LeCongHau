package com.codegym.furama.repositories.customer;

import com.codegym.furama.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerType extends JpaRepository<CustomerType,Integer> {
}
