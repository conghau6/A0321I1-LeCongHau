package model.repositories.impl;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;
import model.repositories.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoriesImpl implements ContractRepositories {
    public static final String SELECT_ALL_CONTRACT = "select contract.contract_id, contract.contract_start_date, contract.contract_end_date, contract.contract_deposit,\n" +
            "contract.contract_total_money, customer.customer_id,customer.customer_name,\n" +
            "service.service_id, service.service_name,\n" +
            "employee.employee_id, employee.employee_name from contract\n" +
            "inner join customer on customer.customer_id = contract.customer_id\n" +
            "inner join employee on employee.employee_id = contract.employee_id\n" +
            "inner join service on service.service_id = contract.service_id;";
    public static final String FIND_BY_ID = "select * from contract where contract.contract_id = ?";
    public static final String INSERT_CONTRACT = "insert into contract value (?,?,?,?,?,?,?,?)";
    public static final String DELETE_CONTRACT = "delete from contract where contract.contract_id = ?";
    @Override
    public List<Contract> findAllContract() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    int contractId = resultSet.getInt("contract_id");
                    Date contractStartDate = resultSet.getDate("contract_start_date");
                    Date contractEndDate = resultSet.getDate("contract_end_date");
                    double contractDeposit = resultSet.getDouble("contract_deposit");
                    double contractTotalMoney = resultSet.getDouble("contract_total_money");
                    int customerId = resultSet.getInt("customer_id");
                    String customerName= resultSet.getString("customer_name");
                    int employeeId = resultSet.getInt("employee_id");
                    String employeeName = resultSet.getString("employee_name");
                    int serviceId = resultSet.getInt("service_id");
                    String serviceName = resultSet.getString("service_name");

                    Contract contract = new Contract(contractId,contractStartDate,contractEndDate,contractDeposit,
                            contractTotalMoney,employeeId,employeeName,customerId,customerName,
                            serviceId,serviceName);
                    contractList.add(contract);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return contractList;
    }

    @Override
    public List<Employee> findAllEmployee() {
        EmployeeRepositories employeeRepositories = new EmployeeRepositoriesImpl();
        return employeeRepositories.findAll();
    }

    @Override
    public List<Customer> findAllCustomer() {
        CustomerRepositories customerRepositories = new CustomerRepositoriesImpl();
        return customerRepositories.findAll();
    }

    @Override
    public List<Service> fillAllService() {
        ServiceRepositories serviceRepositories = new ServiceRepositoriesImpl();
        return serviceRepositories.findAll();
    }

    @Override
    public Contract findById(int id) {
        Connection connection = DBConnection.getConnection();
        Contract contract = null;
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
                preparedStatement.setInt(1,id);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int contractId = resultSet.getInt("contract_id");
                    Date contractStartDate = resultSet.getDate("contract_start_date");
                    Date contractEndDate = resultSet.getDate("contract_end_date");
                    double contractDeposit = resultSet.getDouble("contract_deposit");
                    double contractTotalMoney = resultSet.getDouble("contract_total_money");
                    int customerId = resultSet.getInt("customer_id");
                    int employeeId = resultSet.getInt("employee_id");
                    int serviceId = resultSet.getInt("service_id");

                    contract = new Contract(contractId,contractStartDate,contractEndDate,contractDeposit,
                            contractTotalMoney,employeeId,customerId,
                            serviceId);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return contract;
    }

    @Override
    public void create(Contract contract) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT);
                preparedStatement.setInt(1,contract.getContractId());
                preparedStatement.setDate(2,contract.getContractStartDate());
                preparedStatement.setDate(3,contract.getContractEndDate());
                preparedStatement.setDouble(4,contract.getContractDeposit());
                preparedStatement.setDouble(5,contract.getContractTotalMoney());
                preparedStatement.setInt(6,contract.getEmployeeId());
                preparedStatement.setInt(7, contract.getCustomerId());
                preparedStatement.setInt(8,contract.getServiceId());
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException throwables) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        if(connection !=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT);
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
                connection.commit();

            } catch (SQLException throwables) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            }
            finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Contract contract) {

    }
}
