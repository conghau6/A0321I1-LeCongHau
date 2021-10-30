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
    public static final String INSERT_SERVICE = "insert into service value (?,?,?,?,?,?,?,?,?,?,?)";
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
                    int serviceArea = resultSet.getInt("service_area");
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
    public List<String> findAllStandardRoom () {
        List<String> list = new ArrayList<>();
        list.add("VIP I");
        list.add("VIP II");
        list.add("VIP III");
        list.add("VIP IV");
        list.add("VIP V");
        return list;
    }

    @Override
    public void save(Service service) {
        Connection connection = DBConnection.getConnection();
        try {
            if (connection != null){
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE);
                preparedStatement.setInt(1,service.getServiceId());
                preparedStatement.setString(2,service.getServiceName());
                preparedStatement.setInt(3, service.getServiceArea());
                preparedStatement.setDouble(4,service.getServiceCost());
                preparedStatement.setInt(5,service.getServiceMaxPeople());
                preparedStatement.setInt(6,service.getRentTypeId());
                preparedStatement.setInt(7,service.getServiceTypeId());
                preparedStatement.setString(8,service.getStandardRoom());
                preparedStatement.setString(9,service.getDescriptionOtherConvenient());
                preparedStatement.setDouble(10,service.getPoolArea());
                preparedStatement.setInt(11,service.getNumberOfFloors());
                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
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
