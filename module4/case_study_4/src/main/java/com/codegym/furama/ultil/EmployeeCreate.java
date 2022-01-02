package com.codegym.furama.ultil;

import com.codegym.furama.entity.Division;
import com.codegym.furama.entity.EducationDegree;
import com.codegym.furama.entity.Position;
import com.codegym.furama.entity.User;

import javax.persistence.Entity;

public class EmployeeCreate {
    private Integer employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User username;
}
