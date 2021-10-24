package model.service;

import model.bean.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(int id);
    void update(Customer customer);
    Customer findById(int id);
}
