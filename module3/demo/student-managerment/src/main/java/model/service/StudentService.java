package model.service;

import model.bean.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void addStudent(Student student);
    void update(Student student);
    void delete(Integer id);
    Student findById(Integer id);
}
