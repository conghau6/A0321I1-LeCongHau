package model.service.impl;

import model.bean.customer.Customer;
import model.repositories.CustomerRepositories;
import model.repositories.impl.CustomerRepositoriesImpl;
import model.service.CustomerService;
import model.service.common.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepositories customerRepositories = new CustomerRepositoriesImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public Map<String,String> save(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
        if(Validator.validateCustomerId(customer.getCustomerId()) != null ||
        Validator.validatePhone(customer.getCustomerPhone()) != null ||
        Validator.validateEmail(customer.getCustomerEmail()) != null ||
        Validator.validateIdCard(customer.getCustomerIdCard()) != null){
            mapMessage.put("customerIdErr",Validator.validateCustomerId(customer.getCustomerId()));
            mapMessage.put("customerPhoneErr",Validator.validatePhone(customer.getCustomerPhone()));
            mapMessage.put("customerEmailErr",Validator.validateEmail(customer.getCustomerEmail()));
            mapMessage.put("customerIdCardErr",Validator.validateIdCard(customer.getCustomerIdCard()));
        } else {
            customerRepositories.save(customer);
        }
        return mapMessage;
    }

    @Override
    public void delete(String id) {
        customerRepositories.delete(id);
    }

    @Override
    public Map<String,String> update(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
        if(Validator.validateCustomerId(customer.getCustomerId()) != null ||
                Validator.validatePhone(customer.getCustomerPhone()) != null ||
                Validator.validateEmail(customer.getCustomerEmail()) != null ||
                Validator.validateIdCard(customer.getCustomerIdCard()) != null){
            mapMessage.put("customerIdErr",Validator.validateCustomerId(customer.getCustomerId()));
            mapMessage.put("customerPhoneErr",Validator.validatePhone(customer.getCustomerPhone()));
            mapMessage.put("customerEmailErr",Validator.validateEmail(customer.getCustomerEmail()));
            mapMessage.put("customerIdCardErr",Validator.validateIdCard(customer.getCustomerIdCard()));
        } else {
            customerRepositories.update(customer);
        }
        return mapMessage;
    }

    @Override
    public Customer findById(String id) {
        return customerRepositories.findById(id);
    }
}
