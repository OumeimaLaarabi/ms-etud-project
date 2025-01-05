package etablissement.service.FeignClient;

import etablissement.service.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="STUDENT")

public interface StudentClient {
    @GetMapping("api/student/{id}")
    Optional<Student> getStudentById(@PathVariable int id);
}
