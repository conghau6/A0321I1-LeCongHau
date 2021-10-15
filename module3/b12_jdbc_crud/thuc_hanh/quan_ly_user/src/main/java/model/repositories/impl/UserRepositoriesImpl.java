package model.repositories.impl;

import model.bean.User;
import model.repositories.UserRepositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoriesImpl implements UserRepositories {
    private BaseRepositories baseRepositories = new BaseRepositories();

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (name,email,country)VALUES"+" (?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id = ?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id=?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";

    @Override
    public void addNewUser(User user) {
        System.out.println(INSERT_USERS_SQL);
        try (PreparedStatement preparedStatement = this.baseRepositories.getConnection().prepareStatement(INSERT_USERS_SQL);){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           printSQLException(e);
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        try(PreparedStatement preparedStatement = this.baseRepositories.getConnection().prepareStatement(SELECT_USER_BY_ID);){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id,name,email,country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.baseRepositories.getConnection().prepareStatement(SELECT_ALL_USERS);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement statement = this.baseRepositories.getConnection().prepareStatement(DELETE_USERS_SQL);
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = this.baseRepositories.getConnection().prepareStatement(UPDATE_USERS_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rowUpdate;
    }

    private void printSQLException(SQLException ex) {
        for(Throwable e: ex){
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
