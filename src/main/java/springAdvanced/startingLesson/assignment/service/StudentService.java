package springAdvanced.startingLesson.assignment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import springAdvanced.startingLesson.assignment.dtos.StudentUpdateDto;
import springAdvanced.startingLesson.assignment.entity.Group;
import springAdvanced.startingLesson.assignment.entity.Student;
import springAdvanced.startingLesson.assignment.exeptions.StudentNotFoundException;

import springAdvanced.startingLesson.assignment.repositories.GroupRepository;
import springAdvanced.startingLesson.assignment.repositories.StudentRepository;

import java.util.List;


@Component
public class StudentService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;


    public StudentService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;

    }

    public Student getStudentById(String id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(
                        () -> new StudentNotFoundException(" Not found by given id: " + id));
        return student;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Page<Student> getAllPaged(
            int page,
            int size,
            Sort.Direction direction,
            String field
    ) {
        Sort sort = Sort.by(direction, field);
        Pageable pageable = PageRequest.of(size, page, sort);
        return studentRepository.findAll(pageable);
    }

    public void update(Student newStudent) {
        Student oldStudent = studentRepository
                .findById(newStudent.getId())
                .orElseThrow(
                        () -> new StudentNotFoundException("not found to update (service)"));
        if (newStudent.getName()!=null){
            oldStudent.setName(newStudent.getName());
        }
        if (newStudent.getAge()!=null){
            oldStudent.setAge(newStudent.getAge());
        }
        studentRepository.save(oldStudent);
    }

    public List<Student> getStudentsByGroupId(String id) {
        Group group = groupRepository.findById(id).orElse(null);
        if (group != null) {
            return studentRepository.findAllByGroupId(group.getId());
        }
        return List.of();
    }

    public void create(Student student) {
        studentRepository.save(student);
    }

    public boolean delete(String id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(
                        () -> new StudentNotFoundException("Student not found by given id"));
        studentRepository.delete(student);
        return true;
    }


}
