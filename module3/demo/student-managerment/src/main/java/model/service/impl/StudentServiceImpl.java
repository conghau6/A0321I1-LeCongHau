package model.service.impl;

import model.bean.Student;
import model.repositories.StudentRepositories;
import model.repositories.impl.StudentRepositoriesImpl;
import model.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentRepositories studentRepositories = new StudentRepositoriesImpl();
    @Override
    public List<Student> findAll() {
        return studentRepositories.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepositories.addStudent(student);
    }

    @Override
    public void update(Student student) {
        studentRepositories.update(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepositories.delete(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepositories.findById(id);
    }
}
