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
    public static final String INSERT_EMPLOYEE = "insert into employee value (?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String INSERT_USER = "insert into user value (?,?)";
    public static final String SELECT_ALL_POSITION = "select * from position;";
    public static final String SELECT_ALL_DEGREE = "select * from education_degree;";
    public static final String SELECT_ALL_DIVISION = "select * from division;";
    public static final String FIND_BY_ID = "select * from employee inner join position on position.position_id = employee.position_id\n" +
            "inner join education_degree on education_degree.education_degree_id = employee.education_degree_id\n" +
            "inner join division on division.division_id = employee.division_id\n" +
            "inner join user on user.username = employee.username " +
            "where employee.employee_id = ?;";
    public static final String UPDATE_EMPLOYEE = "update employee inner join position on position.position_id = employee.position_id\n" +
            "inner join education_degree on education_degree.education_degree_id = employee.education_degree_id\n" +
            "inner join division on division.division_id = employee.division_id\n" +
            "inner join user on user.username = employee.username\n" +
            "set employee.employee_name = ?,\n" +
            "employee.employee_birthday = ?,\n" +
            "employee.employee_id_card = ?,\n" +
            "employee.employee_salary = ?,\n" +
            "employee.employee_phone = ?,\n" +
            "employee.employee_email = ?,\n" +
            "employee.employee_address = ?,\n" +
            "employee.position_id = ?,\n" +
            "employee.education_degree_id = ?,\n" +
            "employee.division_id = ?,\n" +
            "`user`.username = ?,\n" +
            "`user`.password = ? \n" +
            "where employee.employee_id = ?;";
    public static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    public static final String DELETE_USER = "delete from user where username = ?;";
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
    public Employee findById(int id) {
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
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

                    employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard,
                            employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId,
                            positionName, educationDegreeId, educationDegreeName, divisionId,
                            divisionName, userName, password);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public void create(Employee employee) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatementEmployee = connection.prepareStatement(INSERT_EMPLOYEE);
                PreparedStatement preparedStatementUser = connection.prepareStatement(INSERT_USER);

                preparedStatementUser.setString(1,employee.getUsername());
                preparedStatementUser.setString(2,employee.getPassword());

                preparedStatementEmployee.setInt(1,employee.getEmployeeId());
                preparedStatementEmployee.setString(2,employee.getEmployeeName());
                preparedStatementEmployee.setDate(3,employee.getEmployeeBirthday());
                preparedStatementEmployee.setString(4,employee.getEmployeeIdCard());
                preparedStatementEmployee.setDouble(5,employee.getEmployeeSalary());
                preparedStatementEmployee.setString(6,employee.getEmployeePhone());
                preparedStatementEmployee.setString(7,employee.getEmployeeEmail());
                preparedStatementEmployee.setString(8,employee.getEmployeeAddress());
                preparedStatementEmployee.setInt(9,employee.getPositionId());
                preparedStatementEmployee.setInt(10,employee.getEducationDegreeId());
                preparedStatementEmployee.setInt(11,employee.getDivisionId());
                preparedStatementEmployee.setString(12,employee.getUsername());

                preparedStatementUser.executeUpdate();
                preparedStatementEmployee.executeUpdate();
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
    }

    @Override
    public void edit(Employee employee) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
                preparedStatement.setString(1,employee.getEmployeeName());
                preparedStatement.setDate(2,employee.getEmployeeBirthday());
                preparedStatement.setString(3,employee.getEmployeeIdCard());
                preparedStatement.setDouble(4,employee.getEmployeeSalary());
                preparedStatement.setString(5,employee.getEmployeePhone());
                preparedStatement.setString(6,employee.getEmployeeEmail());
                preparedStatement.setString(7,employee.getEmployeeAddress());
                preparedStatement.setInt(8,employee.getPositionId());
                preparedStatement.setInt(9,employee.getEducationDegreeId());
                preparedStatement.setInt(10,employee.getDivisionId());
                preparedStatement.setString(11,employee.getUsername());
                preparedStatement.setString(12,employee.getPassword());
                preparedStatement.setInt(13,employee.getEmployeeId());
                preparedStatement.executeUpdate();
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
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                Employee employee = findById(id);
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
                PreparedStatement preparedStatement1 = connection.prepareStatement(DELETE_USER);
                preparedStatement.setInt(1,id);
                preparedStatement1.setString(1,employee.getUsername());
                preparedStatement.executeUpdate();
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
    }
}
