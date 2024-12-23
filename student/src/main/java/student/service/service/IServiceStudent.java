package student.service.service;

import student.service.entity.Student;

import java.util.List;

public interface IServiceStudent {
    Student addStudent(Student student);



    List<Student> getAllStudents();
}
