package model.repositories;

import model.bean.customer.CustomerType;

import java.util.List;

public interface CustomerTypeRepositories {
    List<CustomerType> findAll();
    void save(CustomerType customerType);
    void delete(int id);
    void update(CustomerType customerType);
    CustomerType findById(int id);
}
