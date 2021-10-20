package model.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepositories {
    private String jdbcURL = "jdbc:mysql://localhost:3306/th_demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private Connection connection;

    public BaseRepositories() {
        try{
            // Đăng ký driver
            Class.forName("com.mysql.jdbc.Driver");
            // mở 1 kết nối
            this.connection = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
