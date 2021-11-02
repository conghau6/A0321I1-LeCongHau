package model.service.impl;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;
import model.repositories.ContractRepositories;
import model.repositories.impl.ContractRepositoriesImpl;
import model.service.ContractService;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepositories contractRepositories = new ContractRepositoriesImpl();
    @Override
    public List<Contract> findAllContract() {
        return contractRepositories.findAllContract();
    }

    @Override
    public List<Employee> findAllEmployee() {
        return contractRepositories.findAllEmployee();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return contractRepositories.findAllCustomer();
    }

    @Override
    public List<Service> findAllService() {
        return contractRepositories.fillAllService();
    }

    @Override
    public Contract findById(int id) {
        return null;
    }

    @Override
    public void create(Contract contract) {
        contractRepositories.create(contract);
    }

    @Override
    public void delete(int id) {
        contractRepositories.delete(id);
    }

    @Override
    public void update(Contract contract) {

    }
}
