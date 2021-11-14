package com.codegym.model.service.impl;

import com.codegym.model.bean.Customer;
import com.codegym.model.repositories.CustomerRepositories;
import com.codegym.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepositories customerRepositories;
    @Override
    public List<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public Customer findById(String id) {
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
    public void delete(String id) {
        customerRepositories.delete(id);
    }

    @Override
    public int findId(String id) {
        return customerRepositories.findId(id);
    }
}
