package springAdvanced.assignment.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import springAdvanced.assignment.dtos.StudentCreateDTO;
import springAdvanced.assignment.dtos.StudentUpdateDTO;
import springAdvanced.assignment.entity.Student;
import springAdvanced.assignment.repository.StudentRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@AllArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ConcurrentHashMap<Integer,> concurrentHashMap=new ConcurrentHashMap();

    @Override

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found by given id : " + id));
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(StudentCreateDTO dto) {
        Student student = Student.builder()
                .name(dto.name())
                .age(dto.age())
                .build();

        return studentRepository.save(student);
    }

    @Override
    public void updateStudent(StudentUpdateDTO dto) {


    }

    @Override
    public void deleteStudent(Long id) {

    }
}
