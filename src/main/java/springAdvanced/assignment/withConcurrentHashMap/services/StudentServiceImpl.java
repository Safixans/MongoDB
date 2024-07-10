package springAdvanced.assignment.withConcurrentHashMap.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import springAdvanced.assignment.withConcurrentHashMap.dtos.StudentCreateDTO;
import springAdvanced.assignment.withConcurrentHashMap.dtos.StudentUpdateDTO;
import springAdvanced.assignment.withConcurrentHashMap.entity.Student;
import springAdvanced.assignment.withConcurrentHashMap.repository.StudentRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@AllArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ConcurrentHashMap<Integer, Student> cached = new ConcurrentHashMap<>();

    @Override
    public Student getStudent(Integer id) {
        Student inCacheData = cached.get(id);
        if (inCacheData != null) {
            return inCacheData;
        }

        Student student = studentRepository
                .findById(Long.valueOf(id))
                .orElseThrow(
                        () -> new RuntimeException("Not found by given id : " + id));
        studentRepository.save(student);
        cached.put(id, student);
        return student;
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
        Student
                .builder()
                .name(dto.name())
                .age(dto.age())
                .build();
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(Long.valueOf(id));
        cached.remove(id);
    }
}
