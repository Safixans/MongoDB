package springAdvanced.startingLesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.startingLesson.dtos.PostCreateDTO;
import springAdvanced.startingLesson.dtos.PostUpdateDTO;
import springAdvanced.startingLesson.entity.Post;
import springAdvanced.startingLesson.service.PostService;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @PostMapping
    public ResponseEntity<Post> create(@RequestBody PostCreateDTO dto) {
        return ResponseEntity.status(201).body(postService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PostUpdateDTO dto) {
        postService.update(dto);
        return ResponseEntity.noContent().build();
    }

}
