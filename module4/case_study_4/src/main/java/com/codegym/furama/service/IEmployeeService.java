package com.codegym.furama.service;

import com.codegym.furama.entity.Division;
import com.codegym.furama.entity.EducationDegree;
import com.codegym.furama.entity.Employee;
import com.codegym.furama.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Employee findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);

    Page<Employee> findCustomerByEmployeeName(String name, Pageable pageable);

    List<EducationDegree> findAllDegree();
    List<Position> findAllPosition();
    List<Division> findAllDivision();
}
