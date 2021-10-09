package service.impl;

import entity.Student;
import responsitory.StudentRepository;
import responsitory.impl.StudentRepositoryImpl;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void updateStudent(Integer id, String name, String dateOfBirth) {
        if(name.equals("")){
            System.out.println("Tên không được để trống");
            return;
        }
        if(dateOfBirth.equals("")){
            System.out.println("Ngày sinh không được để trống");
            return;
        }
        if(this.studentRepository.findById(id) == null) {
            System.out.println("Id không tồn tại trong database");
        }
        this.studentRepository.updateStudent(id,name,dateOfBirth);
    }
}
