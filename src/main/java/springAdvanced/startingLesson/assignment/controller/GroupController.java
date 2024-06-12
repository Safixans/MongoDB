package springAdvanced.startingLesson.assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.startingLesson.assignment.entity.Group;
import springAdvanced.startingLesson.assignment.entity.Student;
import springAdvanced.startingLesson.assignment.repositories.GroupRepository;
import springAdvanced.startingLesson.assignment.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupRepository groupRepository;
    private final StudentService service;

    public GroupController(GroupRepository groupRepository, StudentService service) {
        this.groupRepository = groupRepository;
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<Group> create(@RequestBody Group group) {
        return ResponseEntity.ok(groupRepository.save(group));
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Group>> create() {
        return ResponseEntity.ok(groupRepository.findAll());
    }

    @GetMapping("/students-get-grouped/{id}")
    public ResponseEntity<List<Student>> getStudentsByGroupIdByGroupOwnId(@PathVariable String id) {
        return ResponseEntity.ok(service.getStudentsByGroupId(id));
    }
}
