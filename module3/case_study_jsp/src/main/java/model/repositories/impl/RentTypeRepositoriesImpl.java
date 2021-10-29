package model.repositories.impl;

import model.bean.service.RentType;
import model.repositories.DBConnection;
import model.repositories.RenTypeRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoriesImpl implements RenTypeRepositories {
    public static final String SELECT_ALL_RENT_TYPE = "select * from rent_type";
    @Override
    public List<RentType> findAll() {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            if(connection != null){
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    String rentTypeName = resultSet.getString("rent_type_name");
                    double rentTypeCost = resultSet.getDouble("rent_type_cost");

                    rentTypeList.add(new RentType(rentTypeId,rentTypeName,rentTypeCost));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeList;
    }
}
