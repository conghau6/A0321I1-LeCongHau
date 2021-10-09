package responsitory.impl;

import entity.Student;
import responsitory.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(432, "Nguyễn Văn A",
                "09/04/2021", 1, 4.0));
        studentList.add(new Student(986, "Nguyễn Văn B",
                "10/04/2021", 0, 6.0));
        studentList.add(new Student(876, "Nguyễn Văn C",
                "11/04/2021", 1, 9.0));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(Integer id) {
        for(Student student : studentList){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Integer id, String name, String dateOfBirth, Integer gender, Double grade) {
        for(Student student : studentList) {
            if(student.getId().equals(id)) {
                student.setName(name);
                student.setDateOfBirth(dateOfBirth);
                student.setGender(gender);
                student.setGrade(grade);
            }
        }
    }

    @Override
    public void deleteStudent(Integer id) {
        for(int i=0; i<studentList.size(); i++){
            if(studentList.get(i).getId().equals(id)){
                studentList.remove(i);
            }
        }
    }

    @Override
    public void addStudent(Integer id, String name, String dateOfBirth, Integer gender, Double grade) {
        studentList.add(new Student(id,name,dateOfBirth,gender,grade));
    }
}
