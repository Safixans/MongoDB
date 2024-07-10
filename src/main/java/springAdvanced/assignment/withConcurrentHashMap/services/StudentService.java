package springAdvanced.assignment.withConcurrentHashMap.services;

import org.springframework.stereotype.Service;
import springAdvanced.assignment.withConcurrentHashMap.dtos.StudentCreateDTO;
import springAdvanced.assignment.withConcurrentHashMap.dtos.StudentUpdateDTO;
import springAdvanced.assignment.withConcurrentHashMap.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    Student getStudent(Integer id);
    List<Student> getAll();
    Student createStudent(StudentCreateDTO dto);
    void updateStudent(StudentUpdateDTO dto);
    void deleteStudent(Integer id);

}
