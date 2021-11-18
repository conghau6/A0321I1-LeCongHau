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
    public void save(Customer customer) {
        customerRepositories.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepositories.findById(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepositories.update(customer);
    }

    @Override
    public void remove(int id) {
        customerRepositories.remove(id);
    }
}
