package com.codegym.model.repositories.impl;

import com.codegym.model.bean.Customer;
import com.codegym.model.repositories.CustomerRepositories;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoriesImpl implements CustomerRepositories {
    private static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer("Nguyễn Văn A","nva@gmail.com","Đà nẵng"));
        customerList.add(new Customer("Nguyễn Văn B","nvb@gmail.com","Quảng Nam"));
        customerList.add(new Customer("Nguyễn Văn C","nvc@gmail.com","Huế"));
        customerList.add(new Customer("Nguyễn Văn D","nvd@gmail.com","Đà nẵng"));
        customerList.add(new Customer("Nguyễn Văn E","nve@gmail.com","Đà nẵng"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findById(String id) {
        int index = findId(id);
        return customerList.get(index);
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void update(Customer customer) {
        String id = customer.getId();

    }

    @Override
    public void delete(String id) {
        int index = findId(id);
        customerList.remove(index);
    }

    @Override
    public int findId(String id) {
        for(int i=0; i<customerList.size(); i++){
            if(id.equals(customerList.get(i).getId())) return i;
        }
        return -1;
    }
}
