package com.codegym.furama.service;

import com.codegym.furama.entity.*;
import com.codegym.furama.repositories.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    IUserRepositories userRepositories;

    @Autowired
    IRoleRepositories roleRepositories;

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
        User user = new User(employee.getUser().getUsername(), employee.getUser().getPassword());
        // mã hoá mật khẩu
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        int positionId = employee.getPosition().getPositionId();
        Set<Role> roleSet = new HashSet<>();
        // lưu tài khoản employee kèm role
        if(positionId == 5){
            Role roleManager = new Role("ROLE_MANAGER");
            roleSet.add(roleManager);
            user.setRoles(roleSet);
        } if(positionId==6) {
            Role roleManager = new Role("ROLE_CEO");
            roleSet.add(roleManager);
            user.setRoles(roleSet);
        } else {
            Role roleManager = new Role("ROLE_EMPLOYEE");
            roleSet.add(roleManager);
            user.setRoles(roleSet);
        }
        // cập nhật lại user đã mã hoá mật khẩu vào employee
        employee.setUser(user);
        // lưu thông tin user
        userRepositories.save(user);
        // lưu thông tin employee
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
