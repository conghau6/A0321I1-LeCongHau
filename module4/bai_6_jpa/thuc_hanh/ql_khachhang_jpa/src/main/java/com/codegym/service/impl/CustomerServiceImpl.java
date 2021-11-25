package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repositories.CustomerRepositories;
import com.codegym.repositories.impl.CustomerRepositoriesImpl;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepositories customerRepositories;

    @Override
    public List<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepositories.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepositories.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepositories.remove(id);
    }
}
