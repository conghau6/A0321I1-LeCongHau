package com.codegym.furama.repositories.customer;

import com.codegym.furama.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepositories extends JpaRepository<Customer,Integer> {
    Page<Customer> findCustomerByCustomerName(String customerName, Pageable p);
}
