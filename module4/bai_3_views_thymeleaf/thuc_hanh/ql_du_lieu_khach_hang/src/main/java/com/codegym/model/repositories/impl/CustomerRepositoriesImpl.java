package com.codegym.model.repositories.impl;

import com.codegym.model.bean.Customer;
import com.codegym.model.repositories.CustomerRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoriesImpl implements CustomerRepositories {
    private static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerList.add(new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerList.add(new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerList.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerList.add(new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerList.add(new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public int getIndex(int id) {
        for(int i=0; i<customerList.size(); i++){
            if(customerList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        int index = getIndex(id);
        return customerList.get(index);
    }

    @Override
    public void update(Customer customer) {
        int index = getIndex(customer.getId());
        customerList.set(index,customer);
    }

    @Override
    public void remove(int id) {
        int index = getIndex(id);
        customerList.remove(index);
    }
}
