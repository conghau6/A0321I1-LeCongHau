package model.service;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;

import java.util.List;

public interface ContractService {
    List<Contract> findAllContract();
    List<Employee> findAllEmployee();
    List<Customer> findAllCustomer();
    List<Service> findAllService();
    Contract findById(int id);
    void create(Contract contract);
    void delete(int id);
    void update(Contract contract);
}
