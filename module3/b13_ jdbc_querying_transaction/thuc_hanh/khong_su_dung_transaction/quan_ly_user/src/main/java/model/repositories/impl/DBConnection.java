package model.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USER_NAME ="root";
    private static final String PASSWORD = "123456";
    private static final String HOST = "localhost";
    private static final String DATABASE = "th_demo";
    private static final String PORT = "3306";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            // đăng ký drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            // mở 1 kết nối
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT +"/" +DATABASE,USER_NAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if(connection!=null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
