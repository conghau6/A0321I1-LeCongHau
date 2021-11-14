package com.codegym.model.repositories;

import com.codegym.model.bean.Customer;

import java.util.List;

public interface CustomerRepositories {
    List<Customer> findAll();
    Customer findById(String id);
    void save(Customer customer);
    void update(Customer customer);
    void delete(String id);
    int findId(String id);
}
