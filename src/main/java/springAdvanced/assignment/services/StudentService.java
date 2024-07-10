package springAdvanced.assignment.services;

import org.springframework.stereotype.Service;
import springAdvanced.assignment.dtos.StudentCreateDTO;
import springAdvanced.assignment.dtos.StudentUpdateDTO;
import springAdvanced.assignment.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    Student getStudent(Long id);
    List<Student> getAll();
    Student createStudent(StudentCreateDTO dto);
    void updateStudent(StudentUpdateDTO dto);
    void deleteStudent(Long id);

}
