package springAdvanced.assignment.simpleCaching_2.services;

import org.springframework.stereotype.Service;
import springAdvanced.assignment.simpleCaching_2.dtos.StudentCreateDTO;
import springAdvanced.assignment.simpleCaching_2.dtos.StudentUpdateDTO;
import springAdvanced.assignment.simpleCaching_2.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    Student getStudent(Integer id);
    List<Student> getAll();
    Student createStudent(StudentCreateDTO dto);
    void updateStudent(StudentUpdateDTO dto);
    Student deleteStudent(Integer id);

}
