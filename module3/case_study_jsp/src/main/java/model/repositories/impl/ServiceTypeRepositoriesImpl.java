package model.repositories.impl;

import model.bean.service.ServiceType;
import model.repositories.DBConnection;
import model.repositories.ServiceTypeRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoriesImpl implements ServiceTypeRepositories {
    public static final String SELECT_ALL_SERVICE_TYPE = "select * from service_type";
    @Override
    public List<ServiceType> findAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String serviceTypeName = resultSet.getString("service_type_name");

                    serviceTypeList.add(new ServiceType(serviceTypeId,serviceTypeName));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return serviceTypeList;
    }
}
