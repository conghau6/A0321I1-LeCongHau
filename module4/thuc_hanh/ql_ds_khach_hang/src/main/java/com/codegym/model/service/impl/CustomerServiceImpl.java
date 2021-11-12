package com.codegym.model.service.impl;

import com.codegym.model.bean.Customer;
import com.codegym.model.repositories.CustomerRepositories;
import com.codegym.model.repositories.impl.CustomerRepositoriesImpl;
import com.codegym.model.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepositories customerRepositories = new CustomerRepositoriesImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepositories.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepositories.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepositories.update(customer);
    }

    @Override
    public void delete(int id) {
        customerRepositories.delete(id);
    }

    @Override
    public int findIndex(Customer customer) {
        return 0;
    }
}
