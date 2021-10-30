package model.repositories.impl;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.repositories.DBConnection;
import model.repositories.EmployeeRepositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoriesImpl implements EmployeeRepositories {
    public static final String SELECT_ALL_EMPLOYEE = "select * from employee inner join position on position.position_id = employee.position_id\n" +
            "inner join education_degree on education_degree.education_degree_id = employee.education_degree_id\n" +
            "inner join division on division.division_id = employee.division_id\n" +
            "inner join user on user.username = employee.username;";
    public static final String SELECT_ALL_POSITION = "select * from position;";
    public static final String SELECT_ALL_DEGREE = "select * from education_degree;";
    public static final String SELECT_ALL_DIVISION = "select * from division;";
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int employeeId = resultSet.getInt("employee_id");
                    String employeeName = resultSet.getString("employee_name");
                    Date employeeBirthday = resultSet.getDate("employee_birthday");
                    String employeeIdCard = resultSet.getString("employee_id_card");
                    Double employeeSalary = resultSet.getDouble("employee_salary");
                    String employeePhone = resultSet.getString("employee_phone");
                    String employeeEmail = resultSet.getString("employee_email");
                    String employeeAddress = resultSet.getString("employee_address");
                    int positionId = resultSet.getInt("position_id");
                    String positionName = resultSet.getString("position_name");
                    int educationDegreeId = resultSet.getInt("education_degree_id");
                    String educationDegreeName = resultSet.getString("education_degree_name");
                    int divisionId = resultSet.getInt("division_id");
                    String divisionName = resultSet.getString("division_name");
                    String userName = resultSet.getString("username");
                    String password = resultSet.getString("password");

                    Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard,
                            employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId,
                            positionName, educationDegreeId, educationDegreeName, divisionId,
                            divisionName, userName, password);

                    employeeList.add(employee);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return employeeList;
    }

    @Override
    public List<Position> findAllPosition() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    int positionId = resultSet.getInt("position_id");
                    String positionName = resultSet.getString("position_name");

                    Position position = new Position(positionId,positionName);
                    positionList.add(position);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return positionList;
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        List<EducationDegree> degreeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEGREE);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    int educationDegreeId = resultSet.getInt("education_degree_id");
                    String educationDegreeName = resultSet.getString("education_degree_name");

                    EducationDegree degree = new EducationDegree(educationDegreeId,educationDegreeName);
                    degreeList.add(degree);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return degreeList;
    }

    @Override
    public List<Division> findAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    int divisionId = resultSet.getInt("division_id");
                    String divisionName = resultSet.getString("division_name");

                    Division division = new Division(divisionId,divisionName);
                    divisionList.add(division);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return divisionList;
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void edit(Employee employee) {

    }

    @Override
    public void delete(int id) {

    }
}
