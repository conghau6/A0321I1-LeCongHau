package service;

import entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void updateCustomer(Integer id, String name, String email, String address);
    void addCustomer(Integer id, String name, String email, String address);
    void deleteCustomer(Integer id);
}
