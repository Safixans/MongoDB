package springAdvanced.assignment.withRedis.services;

import org.springframework.stereotype.Service;
import springAdvanced.assignment.withRedis.dtos.StudentCreateDTO;
import springAdvanced.assignment.withRedis.dtos.StudentUpdateDTO;
import springAdvanced.assignment.withRedis.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    Student getStudent(Integer id);
    List<Student> getAll();
    Student createStudent(StudentCreateDTO dto);
    void updateStudent(StudentUpdateDTO dto);
    Student deleteStudent(Integer id);

}
