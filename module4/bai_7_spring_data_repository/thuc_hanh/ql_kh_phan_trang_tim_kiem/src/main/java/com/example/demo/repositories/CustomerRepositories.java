package com.example.demo.repositories;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositories extends JpaRepository<Customer,Long> {
    List<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByLastName(String lastName, Pageable p);
}
