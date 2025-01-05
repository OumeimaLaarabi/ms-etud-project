package student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.service.entity.Student;

public interface StudentRespository extends JpaRepository<Student, Integer> {
}
