package responsitory;

import entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(Integer id);
    void updateStudent(Integer id, String name, String dateOfBirth, Integer gender, Double grade);

    void deleteStudent(Integer id);

    void addStudent(Integer id, String name, String dateOfBirth, Integer gender, Double grade);
}
