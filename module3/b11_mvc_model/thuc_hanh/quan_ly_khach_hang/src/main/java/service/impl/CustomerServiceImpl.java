package service.impl;

import entity.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerService = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return this.customerService.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerService.findById(id);
    }

    @Override
    public void updateCustomer(Integer id, String name, String email, String address) {
        this.customerService.updateCustomer(id,name,email,address);
    }

    @Override
    public void addCustomer(Integer id, String name, String email, String address) {
        this.customerService.addCustomer(id,name,email,address);
    }

    @Override
    public void deleteCustomer(Integer id) {
        this.customerService.deleteCustomer(id);
    }
}
