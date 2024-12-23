package student.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student.service.entity.Student;
import student.service.service.IServiceStudent;

@RestController
@RequestMapping("/api/student/")
@AllArgsConstructor

public class StudentRestController {
private IServiceStudent iServiceStudent;
 @PostMapping ("add")
    public Student add(@RequestBody Student Student ){

     return iServiceStudent.addStudent(Student);}

 }


