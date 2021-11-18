package com.codegym.model.repositories;

import com.codegym.model.bean.Customer;

import java.util.List;

public interface CustomerRepositories {
    List<Customer> findAll();

    int getIndex(int id);

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(int id);
}
