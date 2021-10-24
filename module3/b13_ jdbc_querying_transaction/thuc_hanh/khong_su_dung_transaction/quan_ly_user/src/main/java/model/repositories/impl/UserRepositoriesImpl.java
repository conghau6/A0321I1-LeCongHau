package model.repositories.impl;

import model.bean.User;
import model.repositories.UserRepositories;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoriesImpl implements UserRepositories {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (name,email,country)VALUES"+" (?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id = ?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id=?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";
    private static final String SELECT_ALL_USERS_SORT = "select * from users order by name";
    private static final String SQL_TABLE_CREATE = "create table employee(" +
            "id serial," +
            "name varchar(100) not null," +
            "salary numeric(15,2) not null," +
            "created_day timestamp," +
            "primary key(id)" +
            ");";
    private static final String SQL_TABLE_DROP = "drop table if exists employee";
    private static final String SQL_UPDATE = "update employee set salary=? where name=?";
    private static final String SQL_INSERT = "insert into employee(name,salary,created_day) values(?,?,?);";

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
    public void addNewUserTransaction(User user, int[] permisions) {
        Connection connection = DBConnection.getConnection();
        try {
            if(connection!=null){
                connection.setAutoCommit(false);
                PreparedStatement pstmt = connection.prepareStatement(INSERT_USERS_SQL,Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1,user.getName());
                pstmt.setString(2,user.getEmail());
                pstmt.setString(3,user.getCountry());
                int rowAffected = pstmt.executeUpdate();

                ResultSet resultSet = pstmt.getGeneratedKeys();
                int userId = 0;
                if(resultSet.next()) {
                    userId = resultSet.getInt(1);
                    if (rowAffected == 1) {
                        String sqlPivot = "insert into user_permision(user_id,permision_id) values(?,?)";
                        PreparedStatement pstmtAssignment = connection.prepareStatement(sqlPivot);
                        for (int permisionId : permisions) {
                            pstmtAssignment.setInt(1, userId);
                            pstmtAssignment.setInt(2, permisionId);
                            pstmtAssignment.executeUpdate();
                        }
                    }
                    connection.commit();
                } else {
                    connection.rollback();
                }
            }
        } catch (SQLException throwables) {
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        Connection connection = DBConnection.getConnection();
        try {
            if(connection!=null){
                try {
                    PreparedStatement psDrop = connection.prepareStatement(SQL_TABLE_DROP);
                    PreparedStatement psCreate = connection.prepareStatement(SQL_TABLE_CREATE);
                    PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
                    PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);

                    psDrop.executeUpdate();
                    psCreate.executeUpdate();

                    psInsert.setString(1,"Quynh");
                    psInsert.setBigDecimal(2,new BigDecimal(10));
                    psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                    psInsert.executeUpdate();

                    psInsert.setString(1,"Ngan");
                    psInsert.setBigDecimal(2,new BigDecimal(20));
                    psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                    psInsert.executeUpdate();

                    psUpdate.setBigDecimal(2,new BigDecimal(999.99));
                    psUpdate.setString(2,"Quynh");
                    psUpdate.executeUpdate();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
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
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
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
                PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
                statement.setInt(1, id);
                rowDelete = statement.executeUpdate() > 0;
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
                PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.setInt(4, user.getId());

                rowUpdate = statement.executeUpdate() > 0;
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
    public void insertUserStore(User user) {
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
