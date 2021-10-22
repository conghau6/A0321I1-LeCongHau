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
    private static final String SELECT_ALL_USERS_SORT = "select * from users order by name";

    public List<User> sort(){
        Connection connection = DBConnection.getConnection();
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SORT);){
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
    public void addNewUser(User user) {
        Connection connection = DBConnection.getConnection();
        System.out.println(INSERT_USERS_SQL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
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
        Connection connection = DBConnection.getConnection();
        User user = null;
        try{
            if(connection!=null) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
                preparedStatement.setInt(1, id);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    user = new User(id, name, email, country);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        Connection connection = DBConnection.getConnection();
        List<User> users = new ArrayList<>();
        try {
            if(connection!=null) {
                CallableStatement callableStatement = connection.prepareCall("call find_all_users();");
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    users.add(new User(id, name, email, country));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        Connection connection = DBConnection.getConnection();
        boolean rowDelete = false;
        try {
            if(connection!=null) {
                CallableStatement callableStatement = connection.prepareCall("call delete_user(?)");
                callableStatement.setInt(1, id);
                rowDelete = callableStatement.executeUpdate() > 0;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) {
        Connection connection = DBConnection.getConnection();
        boolean rowUpdate = false;
        try {
            if(connection!=null) {
                CallableStatement callableStatement = connection.prepareCall("call update_user(?,?,?,?);");
                callableStatement.setString(1, user.getName());
                callableStatement.setString(2, user.getEmail());
                callableStatement.setString(3, user.getCountry());
                callableStatement.setInt(4, user.getId());

                rowUpdate = callableStatement.executeUpdate() > 0;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public User getUserById(int id) {
        Connection connection = DBConnection.getConnection();
        User user = null;
        String query = "call get_user_by_id(?);";
        try {
            if(connection!=null) {
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setInt(1,id);
                ResultSet resultSet = callableStatement.executeQuery();
                while(resultSet.next()){
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id,name,email,country);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUser(User user) {
        Connection connection = DBConnection.getConnection();
        String query = "call insert_user(?,?,?)";
        try {
            connection.setAutoCommit(false);
            if(connection!=null){
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setString(1,user.getName());
                callableStatement.setString(2,user.getEmail());
                callableStatement.setString(3,user.getCountry());
                callableStatement.executeUpdate();
            }
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
