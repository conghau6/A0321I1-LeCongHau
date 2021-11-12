package com.codegym.model.service;

import com.codegym.model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(String id);
    void save(Customer customer);
    void update(Customer customer);
    void delete(String id);
    int findIndex(String id);
}
