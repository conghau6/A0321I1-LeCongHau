package model.repositories;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;

import java.util.List;

public interface EmployeeRepositories {
    List<Employee> findAll();
    List<Position> findAllPosition();
    List<EducationDegree> findAllEducationDegree();
    List<Division> findAllDivision();
    Employee findById(int id);
    void create(Employee employee);
    void edit(Employee employee);
    void delete(int id);
}
