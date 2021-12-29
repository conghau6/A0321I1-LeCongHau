package com.codegym.furama.repositories;

import com.codegym.furama.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepositories extends JpaRepository<Customer,Integer> {
}
