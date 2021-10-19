package model.repositories.impl;

import model.bean.Student;
import model.repositories.DBConnection;
import model.repositories.StudentRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoriesImpl implements StudentRepositories {
    private static final String SELECT_ALL_STUDENT = "select * from student;";
    private static final String FIND_BY_ID = "select id, name, email, phone from student where id = ?;";
    private static final String ADD_STUDENT = "insert into student values (?,?,?,?);";
    private static final String UPDATE_STUDENT = "update student set name = ?, email = ?, phone = ? where id = ?";
    private static final String DELETE_STUDENT = "delete from student where id = ?;";
    @Override
    public List<Student> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Student> studentList = new ArrayList<>();
        if(connection!=null){
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    studentList.add( new Student(id,name,email,phone));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_STUDENT);
                preparedStatement.setInt(1, student.getId());
                preparedStatement.setString(2,student.getName());
                preparedStatement.setString(3, student.getEmail());
                preparedStatement.setString(4, student.getPhone());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Student student) {
        Connection connection = DBConnection.getConnection();
        try {
            if(connection!=null){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
                    preparedStatement.setString(1,student.getName());
                    preparedStatement.setString(2,student.getEmail());
                    preparedStatement.setString(3,student.getPhone());
                    preparedStatement.setInt(4, student.getId());
                    preparedStatement.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = DBConnection.getConnection();
        try {
            if(connection!=null){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
                    preparedStatement.setInt(1,id);
                    preparedStatement.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Student findById(Integer id) {
        Connection connection = DBConnection.getConnection();
        Student student = null;
        try{
            if(connection!=null){
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setEmail(resultSet.getString("email"));
                    student.setPhone(resultSet.getString("phone"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }
}
