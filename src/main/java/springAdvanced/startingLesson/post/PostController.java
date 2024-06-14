package springAdvanced.startingLesson.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.startingLesson.post.dtos.CommentCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostDTO;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<PostDTO> getPost(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostCreateDTO dto) {
        return ResponseEntity.ok(postService.createPost(dto));
    }
    @PostMapping("/comment")
    public ResponseEntity<Void> createComments(@RequestBody List<CommentCreateDTO> dtos) {
        postService.createComment(dtos);
        return ResponseEntity.notFound().build();
    }


}

