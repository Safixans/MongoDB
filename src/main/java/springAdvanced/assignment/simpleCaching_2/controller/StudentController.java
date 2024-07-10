package springAdvanced.assignment.simpleCaching_2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.assignment.simpleCaching_2.dtos.StudentCreateDTO;
import springAdvanced.assignment.simpleCaching_2.dtos.StudentUpdateDTO;
import springAdvanced.assignment.simpleCaching_2.entity.Student;
import springAdvanced.assignment.simpleCaching_2.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student/api")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody StudentCreateDTO dto) {
        studentService.createStudent(dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody StudentUpdateDTO dto) {
        studentService.updateStudent(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
