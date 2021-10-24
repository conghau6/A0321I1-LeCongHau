package model.service.impl;

import model.bean.customer.Customer;
import model.repositories.CustomerRepositories;
import model.repositories.impl.CustomerRepositoriesImpl;
import model.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepositories customerRepositories = new CustomerRepositoriesImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepositories.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepositories.delete(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepositories.update(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepositories.findById(id);
    }
}
