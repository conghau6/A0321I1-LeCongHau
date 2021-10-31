package model.service.impl;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.repositories.EmployeeRepositories;
import model.repositories.impl.EmployeeRepositoriesImpl;
import model.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepositories employeeRepositories = new EmployeeRepositoriesImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepositories.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return employeeRepositories.findAllPosition();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return employeeRepositories.findAllEducationDegree();
    }

    @Override
    public List<Division> findAllDivision() {
        return employeeRepositories.findAllDivision();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepositories.findById(id);
    }

    @Override
    public void create(Employee employee) {
        employeeRepositories.create(employee);
    }

    @Override
    public void edit(Employee employee) {

    }

    @Override
    public void delete(int id) {

    }
}
