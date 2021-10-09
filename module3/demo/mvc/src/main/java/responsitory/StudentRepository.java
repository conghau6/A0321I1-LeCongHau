package responsitory;

import entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(Integer id);
    void updateStudent(Integer id, String name, String dateOfBirth);
}
