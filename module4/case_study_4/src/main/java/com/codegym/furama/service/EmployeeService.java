package com.codegym.furama.service;

import com.codegym.furama.entity.Division;
import com.codegym.furama.entity.EducationDegree;
import com.codegym.furama.entity.Employee;
import com.codegym.furama.entity.Position;
import com.codegym.furama.repositories.employee.IDivisionRepositories;
import com.codegym.furama.repositories.employee.IEducationDegreeRepositories;
import com.codegym.furama.repositories.employee.IEmployeeRepositories;
import com.codegym.furama.repositories.employee.IPositionRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepositories employeeRepositories;

    @Autowired
    IEducationDegreeRepositories educationDegreeRepositories;

    @Autowired
    IDivisionRepositories divisionRepositories;

    @Autowired
    IPositionRepositories positionRepositories;

    @Override
    public List<Employee> findAll() {
        return employeeRepositories.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepositories.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepositories.save(employee);
    }

    @Override
    public void remove(Integer id) {
        employeeRepositories.deleteById(id);
    }

    @Override
    public Page<Employee> findCustomerByEmployeeName(String name, Pageable pageable) {
        return employeeRepositories.findCustomerByEmployeeName(name,pageable);
    }

    @Override
    public List<EducationDegree> findAllDegree() {
        return educationDegreeRepositories.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepositories.findAll();
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepositories.findAll();
    }
}
