package com.codegym.furama.ultil;

import com.codegym.furama.entity.Employee;
import com.codegym.furama.entity.User;

public class EmployeeCreate {
    private Integer employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private Integer positionId;
    private Integer degreeId;
    private Integer divisionId;
    private String username;
    private String password;

    private Employee employee;

    public EmployeeCreate() {
    }

    public EmployeeCreate(Integer employeeId, String employeeName, String employeeBirthday, String employeeIdCard, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Integer positionId, Integer degreeId, Integer divisionId, String username, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.degreeId = degreeId;
        this.divisionId = divisionId;
        this.username = username;
        this.password = password;
    }

    public EmployeeCreate(String employeeName, String employeeBirthday, String employeeIdCard, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Integer positionId, Integer degreeId, Integer divisionId, String username, String password) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.degreeId = degreeId;
        this.divisionId = divisionId;
        this.username = username;
        this.password = password;
    }

    public EmployeeCreate(Employee e){
        this.employeeId = e.getEmployeeId();
        this.employeeName = e.getEmployeeName();
        this.employeeBirthday = e.getEmployeeBirthday();
        this.employeeIdCard = e.getEmployeeIdCard();
        this.employeeSalary = e.getEmployeeSalary();
        this.employeePhone = e.getEmployeePhone();
        this.employeeEmail = e.getEmployeeEmail();
        this.employeeAddress = e.getEmployeeAddress();
        this.positionId = e.getPosition().getPositionId();
        this.degreeId = e.getEducationDegree().getEducationDegreeId();
        this.divisionId = e.getDivision().getDivisionId();
        this.username = e.getUser().getUsername();
        this.password = e.getUser().getPassword();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
