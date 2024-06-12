package springAdvanced.startingLesson.assignment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.startingLesson.assignment.dtos.StudentUpdateDto;
import springAdvanced.startingLesson.assignment.entity.Student;
import springAdvanced.startingLesson.assignment.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student-access")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Student>> getAllPaged(
            @RequestParam int size,
            @RequestParam int page,
            @RequestParam Sort.Direction direction,
            @RequestParam String field
    ) {
        return ResponseEntity.ok(studentService.getAllPaged(page, size, direction, field));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@RequestBody Student student) {
        studentService.update(student);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/group-id/{groupId}")
    public ResponseEntity<List<Student>> getStudentsByGroupId(@PathVariable String groupId) {
        return ResponseEntity.ok(studentService.getStudentsByGroupId(groupId));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Student student) {
        studentService.create(student);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
