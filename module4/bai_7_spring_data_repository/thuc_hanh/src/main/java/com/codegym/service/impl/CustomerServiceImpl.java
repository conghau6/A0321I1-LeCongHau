package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repositories.CustomerRepositories;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepositories customerRepositories;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepositories.save(customer);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return null;
    }
}
