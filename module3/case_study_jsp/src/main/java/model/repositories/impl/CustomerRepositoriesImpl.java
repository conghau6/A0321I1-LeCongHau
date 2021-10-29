package model.repositories.impl;

import model.bean.customer.Customer;
import model.repositories.CustomerRepositories;
import model.repositories.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoriesImpl implements CustomerRepositories {
    public static final String SELECT_ALL_CUSTOMER = "select * from customer inner join customer_type " +
            "on customer.customer_type_id = customer_type.customer_type_id;";
    public static final String INSERT_CUSTOMER = "insert into customer values(?,?,?,?,?,?,?,?,?);";
    public static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?," +
            "customer_name=?, customer_birthday=?, customer_gender=?,customer_id_card=?," +
            "customer_phone=?,customer_email=?, customer_address=?" +
            "where customer_id=?;";
    public static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_CUSTOMER);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int customerId = resultSet.getInt("customer_id");
                    int customerTypeId = resultSet.getInt("customer_type_id");
                    String customerTypeName = resultSet.getString("customer_type_name");
                    String customerName = resultSet.getString("customer_name");
                    String customerBirthday = resultSet.getString("customer_birthday");
                    int customerGender = resultSet.getInt("customer_gender");
                    String customerIdCard = resultSet.getString("customer_id_card");
                    String customerPhone = resultSet.getString("customer_phone");
                    String customerEmail = resultSet.getString("customer_email");
                    String customerAddress = resultSet.getString("customer_address");

                    customerList.add(new Customer(customerId,customerTypeId,customerTypeName,customerName,customerBirthday,customerGender
                            ,customerIdCard,customerPhone,customerEmail,customerAddress));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if(connection!=null) connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
                preparedStatement.setInt(1,customer.getCustomerId());
                preparedStatement.setInt(2,customer.getCustomerTypeId());
                preparedStatement.setString(3,customer.getCustomerName());
                preparedStatement.setString(4,customer.getCustomerBirthday());
                preparedStatement.setInt(5,customer.getCustomerGender());
                preparedStatement.setString(6,customer.getCustomerIdCard());
                preparedStatement.setString(7,customer.getCustomerPhone());
                preparedStatement.setString(8,customer.getCustomerEmail());
                preparedStatement.setString(9,customer.getCustomerAddress());
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
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
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
        }
    }

    @Override
    public void update(Customer customer) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
                preparedStatement.setInt(1,customer.getCustomerTypeId());
                preparedStatement.setString(2,customer.getCustomerName());
                preparedStatement.setString(3,customer.getCustomerBirthday());
                preparedStatement.setInt(4,customer.getCustomerGender());
                preparedStatement.setString(5,customer.getCustomerIdCard());
                preparedStatement.setString(6,customer.getCustomerPhone());
                preparedStatement.setString(7,customer.getCustomerEmail());
                preparedStatement.setString(8,customer.getCustomerAddress());
                preparedStatement.setInt(9,customer.getCustomerId());
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
        }
    }

    @Override
    public Customer findById(int id) {
        for(Customer customer : findAll()){
            if(customer.getCustomerId() == id){
                return customer;
            }
        }
        return null;
    }
}
