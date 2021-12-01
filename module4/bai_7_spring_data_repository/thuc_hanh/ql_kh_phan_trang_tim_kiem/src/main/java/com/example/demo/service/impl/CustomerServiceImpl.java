package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.repositories.CustomerRepositories;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepositories.findAll(pageable);
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

    @Override
    public List<Customer> findAllByProvince(Province province) {
        return customerRepositories.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByLastName(String lastName, Pageable p) {
        return customerRepositories.findAllByLastName(lastName,p);
    }
}
