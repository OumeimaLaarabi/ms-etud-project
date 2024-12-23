package student.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import student.service.entity.Student;
import student.service.repository.StudentRespository;

import java.util.List;

@Service
@AllArgsConstructor
public  class ServiceStudent implements IServiceStudent {

    private    StudentRespository studentRespository;

    @Override
    public Student addStudent(Student student) {
        return studentRespository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRespository.findAll();
    }
}
