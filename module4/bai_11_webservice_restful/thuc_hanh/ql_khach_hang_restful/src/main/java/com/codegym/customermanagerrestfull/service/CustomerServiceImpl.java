package com.codegym.customermanagerrestfull.service;

import com.codegym.customermanagerrestfull.model.Customer;
import com.codegym.customermanagerrestfull.repositories.CustomerRepositories;
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
        return customerRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepositories.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepositories.deleteById(id);
    }
}
