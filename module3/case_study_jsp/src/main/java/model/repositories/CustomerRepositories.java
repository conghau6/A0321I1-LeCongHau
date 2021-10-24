package model.repositories;

import model.bean.customer.Customer;

import java.util.List;

public interface CustomerRepositories {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(int id);
    void update(Customer customer);
    Customer findById(int id);
}
