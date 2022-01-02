package com.codegym.furama.service;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.repositories.customer.ICustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepositories customerRepositories;

    @Override
    public List<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepositories.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepositories.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepositories.deleteById(id);
    }

    @Override
    public Page<Customer> findCustomerByCustomerName(String customerName, Pageable pageable) {
        return customerRepositories.findCustomerByCustomerName(customerName, pageable);
    }
}
