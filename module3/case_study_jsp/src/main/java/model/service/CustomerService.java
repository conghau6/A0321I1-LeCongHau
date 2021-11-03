package model.service;

import model.bean.customer.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();
    Map<String,String> save(Customer customer);
    void delete(String id);
    Map<String,String> update(Customer customer);
    Customer findById(String id);
}
