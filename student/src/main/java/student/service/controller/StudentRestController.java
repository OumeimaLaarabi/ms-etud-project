package student.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.service.entity.Student;
import student.service.service.IServiceStudent;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student/")
@AllArgsConstructor

public class StudentRestController {
    private IServiceStudent iServiceStudent;

    @PostMapping("add")
    public Student add(@RequestBody Student Student) {

        return iServiceStudent.addStudent(Student);
    }

    @GetMapping("all")
    public List<Student> allStudents() {
        return iServiceStudent.getAllStudents();
    }

    @GetMapping("{id}")
    public Optional<Student> getById(@PathVariable int id) {
        return iServiceStudent.getStudentById(id);
    }

}


