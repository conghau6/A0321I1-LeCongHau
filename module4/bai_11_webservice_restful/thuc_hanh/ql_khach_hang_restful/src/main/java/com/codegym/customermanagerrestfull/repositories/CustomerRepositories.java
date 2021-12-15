package com.codegym.customermanagerrestfull.repositories;

import com.codegym.customermanagerrestfull.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositories extends JpaRepository<Customer,Long> {

}
