package com.codegym.furama.repositories.employee;

import com.codegym.furama.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepositories extends JpaRepository<Employee,Integer> {
    Page<Employee> findCustomerByEmployeeName(String name, Pageable p);
}
