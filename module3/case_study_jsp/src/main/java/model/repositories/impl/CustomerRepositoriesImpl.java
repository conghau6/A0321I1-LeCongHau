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

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }
}
