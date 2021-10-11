package repository.impl;

import entity.Customer;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(145, "John", "john@codegym.vn", "Hanoi"));
        customerList.add(new Customer(234, "Bill", "bill@codegym.vn", "Danang"));
        customerList.add(new Customer(563, "Alex", "alex@codegym.vn", "Saigon"));
        customerList.add(new Customer(454, "Adam", "adam@codegym.vn", "Beijin"));
        customerList.add(new Customer(584, "Sophia", "sophia@codegym.vn", "Miami"));
        customerList.add(new Customer(644, "Rose", "rose@codegym.vn", "Newyork"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findById(Integer id) {
        for(Customer customer : customerList) {
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void updateCustomer(Integer id, String name, String email, String address) {
        for(Customer customer : customerList){
            if(customer.getId().equals(id)){
                customer.setId(id);
                customer.setName(name);
                customer.setEmail(email);
                customer.setAddress(address);
            }
        }
    }

    @Override
    public void addCustomer(Integer id, String name, String email, String address){
        customerList.add(new Customer(id,name,email,address));
    }

    @Override
    public void deleteCustomer(Integer id) {
        for(int i=0; i<customerList.size(); i++){
            if(customerList.get(i).getId().equals(id)){
                customerList.remove(i);
            }
        }
    }
}
