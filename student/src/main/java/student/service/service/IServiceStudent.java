package student.service.service;

import student.service.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IServiceStudent {
    Student addStudent(Student student);


    List<Student> getAllStudents();

    public Optional<Student> getStudentById(int id);
}
