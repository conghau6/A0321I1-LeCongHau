package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllException(Pageable pageable) throws Exception;

    Customer findById(Long id) throws Exception;

    void save(Customer customer);

    void remove(Long id);

    List<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByLastName(String lastName, Pageable p);

    Page<Customer> customQuery(String firstName, Pageable p);
}
