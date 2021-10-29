package model.repositories.impl;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repositories.CustomerTypeRepositories;
import model.repositories.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoriesImpl implements CustomerTypeRepositories {
    public static final String SELECT_ALL_CUSTOMER_TYPE = "select * from customer_type";

    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int customerTypeId = resultSet.getInt("customer_type_id");
                    String customerTypeName = resultSet.getString("customer_type_name");
                    customerTypeList.add(new CustomerType(customerTypeId,customerTypeName));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return customerTypeList;
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(CustomerType customerType) {

    }

    @Override
    public CustomerType findById(int id) {
        return null;
    }
}
