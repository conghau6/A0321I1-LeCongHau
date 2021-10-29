package model.service.impl;

import model.bean.customer.CustomerType;
import model.repositories.CustomerTypeRepositories;
import model.repositories.impl.CustomerTypeRepositoriesImpl;
import model.service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepositories customerTypeRepositories = new CustomerTypeRepositoriesImpl();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepositories.findAll();
    }
}
