package model.repositories.impl;

import model.bean.service.Service;
import model.repositories.DBConnection;
import model.repositories.ServiceRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoriesImpl implements ServiceRepositories {
    public static final String SELECT_ALL_SERVICE = "select * from service inner join " +
            "service_type on service.service_type_id = service_type.service_type_id inner join " +
            "rent_type on service.rent_type_id = rent_type.rent_type_id;";
    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    int serviceId = resultSet.getInt("service_id");
                    String serviceName = resultSet.getString("service_name");
                    double serviceArea = resultSet.getDouble("service_area");
                    double serviceCost = resultSet.getDouble("service_cost");
                    int serviceMaxPeople = resultSet.getInt("service_max_people");
                    String rentTypeName  =resultSet.getString("rent_type_name");
                    String serviceTypeName = resultSet.getString("service_type_name");
                    String standardRoom = resultSet.getString("standard_room");
                    String desc = resultSet.getString("description_other_convenience");
                    double poolArea = resultSet.getDouble("pool_area");
                    int numberOfFloor = resultSet.getInt("number_of_floors");

                    Service service = new Service(serviceId,serviceName,serviceArea,serviceCost,serviceMaxPeople,
                            rentTypeName,serviceTypeName,standardRoom,desc,poolArea,numberOfFloor);
                    serviceList.add(service);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return serviceList;
    }

    @Override
    public void save(Service service) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Service service) {

    }

    @Override
    public Service findById(int id) {
        return null;
    }
}
